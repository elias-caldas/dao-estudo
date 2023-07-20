package application;

import db.DaoFactory;
import model.dao.ProdutosDAO;
import model.entetities.Produtos;

public class Program {

	public static void main(String[] args) {
		
		ProdutosDAO produtosDAO = DaoFactory.createProdutosDao();
		
		Produtos novoProduto = new Produtos (null, "Beleza", 50.9);
		produtosDAO.insert(novoProduto);
		System.out.println("Inserido! Novo id = " + novoProduto.getIdProdutos());
	}

}
