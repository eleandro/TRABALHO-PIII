package br.edu.unisep.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class HotelController {
	
	@FXML
	private BorderPane corpo;

	@FXML	
	public void abrirCadastroCliente(MouseEvent event)throws IOException{
		AnchorPane telaCliente= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/CadastroClientes.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaCliente);
	}
	
	@FXML	
	public void abrirRecpecao(MouseEvent event)throws IOException{
		AnchorPane telaRecepcao= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/Recepcao.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaRecepcao);
	}
	
	@FXML	
	public void pesquisarClientes(MouseEvent event)throws IOException{
		AnchorPane telaPesquisaClientes= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/PesquisarClientes.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaPesquisaClientes);
	}
	
	@FXML	
	public void hospedagem(MouseEvent event)throws IOException{
		AnchorPane telaHospedagem= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/Hospedagem.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaHospedagem);
	}
	
	@FXML	
	public void pesquisarHospedagem(MouseEvent event)throws IOException{
		AnchorPane telaPesquisaHospedagem= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/PesquisarHospedagem.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaPesquisaHospedagem);
	}
	@FXML	
	public void cadastroApartamentos(MouseEvent event)throws IOException{
		AnchorPane telaApartamento= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/Apartamento.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaApartamento);
	}
	
	@FXML	
	public void cadastroProdutos(MouseEvent event)throws IOException{
		AnchorPane telaProdutos= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/Produtos.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaProdutos);
	}
	
	@FXML	
	public void consumo(MouseEvent event)throws IOException{
		AnchorPane telaConsumo= (AnchorPane) FXMLLoader.load(getClass().getResource("telas/Consumo.fxml"));
		//remove to
		corpo.getChildren().clear();
		
		corpo.setCenter(telaConsumo);
	}
}
