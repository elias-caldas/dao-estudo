package model;

import java.io.Serializable;
import java.util.Objects;

public class Produtos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer idProdutos;
	private String Tipo;
	private Double Preço;
	
	public Produtos(Integer idProdutos, String tipo, Double preço) {
		super();
		this.idProdutos = idProdutos;
		this.Tipo = tipo;
		this.Preço = preço;
	}

	public Integer getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(Integer idProdutos) {
		this.idProdutos = idProdutos;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public Double getPreço() {
		return Preço;
	}

	public void setPreço(Double preço) {
		Preço = preço;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProdutos);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtos other = (Produtos) obj;
		return Objects.equals(idProdutos, other.idProdutos);
	}

	@Override
	public String toString() {
		return "Produtos [idProdutos=" + idProdutos + ", Tipo=" + Tipo + ", Preço=" + Preço + "]";
	}
	
	

}
