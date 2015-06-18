package br.edu.unisep.hotel.vo;

public class ProdutosVO {
	
	private Integer id;
	
	private String produto;
	
	private double valorUnitarioProduto;
	
	private Integer quantidadeProduto;
	
	private CategoriaProdutosVO categoriaProduto;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public CategoriaProdutosVO getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProdutosVO categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	
	
	
	
}
