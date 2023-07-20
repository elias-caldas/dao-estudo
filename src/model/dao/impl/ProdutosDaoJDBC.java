package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProdutosDAO;
import model.entetities.Produtos;

public class ProdutosDaoJDBC implements ProdutosDAO {
	
	private Connection conn;
	
	public ProdutosDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Produtos p) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO produtos (Tipo, Preço) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, p.getTipo());
			st.setDouble(2, p.getPreço());
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					p.setIdProdutos(id);
					DB.closeResultSet(rs);
				}
			}else {
				throw new DbException("Erro inexperado.Nenhuma linha alterada");
			}
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
				
	}

	@Override
	public void update(Produtos p) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("UPDATE Produtos SET Tipo = ?, Preço = ? WHERE idProdutos = ?");
			st.setString(1, p.getTipo());
			st.setDouble(2, p.getPreço());
			st.setInt(3, p.getIdProdutos());
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}		
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Produtos findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("select produtos.* FROM produtos WHERE produtos.idProdutos = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Produtos produtos = new Produtos();
				produtos.setIdProdutos(rs.getInt("idProdutos"));
				produtos.setPreço(rs.getDouble("Preço"));
				produtos.setTipo(rs.getString("Tipo"));
				return produtos;
				
				
			}
			return null;
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			
		}	
	}

}
