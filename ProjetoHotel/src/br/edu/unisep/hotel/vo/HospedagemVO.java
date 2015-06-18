package br.edu.unisep.hotel.vo;

import java.time.LocalDate;


public class HospedagemVO {
	
	private Integer id;
	

	private String contato;
	
	private LocalDate dataEntrada;
	
	private LocalDate dataSaida;
	
	private Integer diaria;
	
	private String observacao;
	
	private ClientesVO cliente;
	
	private ApartamentoVO categorias;
	
	private Double totalDiaria;
	
	private Double valorDiaria;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getDiaria() {
		return diaria;
	}

	public void setDiaria(Integer diaria) {
		this.diaria = diaria;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ClientesVO getCliente() {
		return cliente;
	}

	public void setCliente(ClientesVO cliente) {
		this.cliente = cliente;
	}

	public ApartamentoVO getCategorias() {
		return categorias;
	}

	public void setCategorias(ApartamentoVO categorias) {
		this.categorias = categorias;
	}

	public Double getTotalDiaria() {
		return totalDiaria;
	}

	public void setTotalDiaria(Double totalDiaria) {
		this.totalDiaria = totalDiaria;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	

	

}
