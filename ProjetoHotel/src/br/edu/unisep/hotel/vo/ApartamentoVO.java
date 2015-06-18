package br.edu.unisep.hotel.vo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ApartamentoVO {
	
	private SimpleIntegerProperty id;
	
	private SimpleStringProperty categoria;
	
	private SimpleStringProperty numeroApartamento;
	
	private SimpleStringProperty capacidade;
	
	private SimpleStringProperty observacao;
	
	
	public ApartamentoVO(){
		this.id = new SimpleIntegerProperty();
		this.categoria = new SimpleStringProperty();
		this.numeroApartamento = new SimpleStringProperty();
		this.capacidade = new SimpleStringProperty();
		this.observacao = new SimpleStringProperty();
	}
	
	
	public String toString() {
	    return categoria.get()+""+numeroApartamento.get();
	    
	}
	

	public SimpleStringProperty toString(String cat){
		return categoria;
	}

	public SimpleIntegerProperty idProperty() {
		return this.id;
	}



	public int getId() {
		return this.idProperty().get();
	}



	public void setId(final int id) {
		this.idProperty().set(id);
	}



	public SimpleStringProperty categoriaProperty() {
		return this.categoria;
	}



	public java.lang.String getCategoria() {
		return this.categoriaProperty().get();
	}



	public void setCategoria(final java.lang.String categoria) {
		this.categoriaProperty().set(categoria);
	}


	public SimpleStringProperty numeroApartamentoProperty() {
		return this.numeroApartamento;
	}



	public java.lang.String getNumeroApartamento() {
		return this.numeroApartamentoProperty().get();
	}



	public void setNumeroApartamento(final java.lang.String numeroApartamento) {
		this.numeroApartamentoProperty().set(numeroApartamento);
	}



	public SimpleStringProperty capacidadeProperty() {
		return this.capacidade;
	}



	public java.lang.String getCapacidade() {
		return this.capacidadeProperty().get();
	}



	public void setCapacidade(final java.lang.String capacidade) {
		this.capacidadeProperty().set(capacidade);
	}



	public SimpleStringProperty observacaoProperty() {
		return this.observacao;
	}



	public java.lang.String getObservacao() {
		return this.observacaoProperty().get();
	}



	public void setObservacao(final java.lang.String observacao) {
		this.observacaoProperty().set(observacao);
	}
	
	
		
	
	
	

}
