package application;

import java.util.Scanner;

import db.DaoFactory;
import model.dao.ProdutosDAO;
import model.entetities.Produtos;

public class Program {

	public static void main(String[] args) {
		
		ProdutosDAO produtosDAO = DaoFactory.createProdutosDao();
		
		Produtos novoProdutos;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o id que você deseja deletar: ");
		
		int id  = scan.nextInt();
		produtosDAO.deleteById(id);
	}

}
