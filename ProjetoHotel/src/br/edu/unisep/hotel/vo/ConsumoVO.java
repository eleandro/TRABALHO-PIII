package br.edu.unisep.hotel.vo;

public class ConsumoVO {
	
	private Integer id;
	
	private double valorTotalUnitario;
	
	private double valorTotal;
	
	private int quantidadeConsumo;
	
	private HospedagemVO hospedagem;
	
	private ProdutosVO produtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValorTotalUnitario() {
		return valorTotalUnitario;
	}

	public void setValorTotalUnitario(double valorTotalUnitario) {
		this.valorTotalUnitario = valorTotalUnitario;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuantidadeConsumo() {
		return quantidadeConsumo;
	}

	public void setQuantidadeConsumo(int quantidadeConsumo) {
		this.quantidadeConsumo = quantidadeConsumo;
	}

	public HospedagemVO getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(HospedagemVO hospedagem) {
		this.hospedagem = hospedagem;
	}

	public ProdutosVO getProdutos() {
		return produtos;
	}

	public void setProdutos(ProdutosVO produtos) {
		this.produtos = produtos;
	}
	
	
	
	

}
