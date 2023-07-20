package model.dao;

import java.util.List;

import model.entetities.Produtos;

public interface ProdutosDAO {
	
	void insert(Produtos p);
	
	void update(Produtos p);
	
	void deleteById (Integer id);
	
	Produtos findById (Integer id);
	

}
