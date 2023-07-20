package db;

import model.dao.impl.ProdutosDaoJDBC;
import model.dao.ProdutosDAO;

public class DaoFactory {
	
	public static ProdutosDAO createProdutosDao() {
		return new ProdutosDaoJDBC();
	}
}
