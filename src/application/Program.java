package application;

import db.DaoFactory;
import model.dao.ProdutosDAO;
import model.entetities.Produtos;

public class Program {

	public static void main(String[] args) {
		
		ProdutosDAO produtosDAO = DaoFactory.createProdutosDao();
		
		Produtos novoProdutos;
		novoProdutos = produtosDAO.findById(2);
		novoProdutos.setTipo("João");
		produtosDAO.update(novoProdutos);
		System.out.println("Atualização completa!");
	}

}
