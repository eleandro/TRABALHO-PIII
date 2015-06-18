package br.edu.unisep.hotel.vo;

public class FinanceiroVO {
	
	private Integer id;
	
	private double valorCredito;
	
	private double valorDebito;
	
	private HospedagemVO hospedagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public double getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(double valorDebito) {
		this.valorDebito = valorDebito;
	}

	public HospedagemVO getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(HospedagemVO hospedagem) {
		this.hospedagem = hospedagem;
	}
	
	

}
