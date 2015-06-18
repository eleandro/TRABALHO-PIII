package br.edu.unisep.view.telas;


import java.net.URL;

import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class RecepcaoController implements Initializable {

	
	@FXML
	private MenuItem mniStatus;
	@FXML
	private MenuItem mniStatus1;
	@FXML
	private MenuItem mniStatus2;
	@FXML
	private MenuItem mniStatus3;
	@FXML
	private MenuItem mniStatus4;
	@FXML
	private MenuItem mniStatus5;
	@FXML
	private MenuItem mniStatus6;
	@FXML
	private MenuItem mniStatus7;
	@FXML
	private MenuItem mniStatus8;
	@FXML
	private MenuItem mniStatus9;
	
	@FXML
	private ImageView imgPorta;
	@FXML
	private ImageView imgPorta1;
	@FXML
	private ImageView imgPorta2;
	@FXML
	private ImageView imgPorta3;
	@FXML
	private ImageView imgPorta4;
	@FXML
	private ImageView imgPorta5;
	@FXML
	private ImageView imgPorta6;
	@FXML
	private ImageView imgPorta7;
	@FXML
	private ImageView imgPorta8;
	@FXML
	private ImageView imgPorta9;
	
	
	
	@FXML
	public void mudarLivre(ActionEvent event) {
		mniStatus.setText("Livre");
		
		Image img = new Image("/br/edu/unisep/hotel/icones/imagens/livre.png");
		imgPorta.setImage(img);
		
	}
	@FXML
	public void mudarLivre1(ActionEvent event) {
		mniStatus1.setText("Livre");
		
		Image img1 = new Image("/br/edu/unisep/hotel/icones/imagens/livre.png");
		imgPorta1.setImage(img1);
	}
	
	@FXML
	public void mudarOcupado(ActionEvent event) {
		mniStatus.setText("Ocupada");
		
		Image img = new Image("/br/edu/unisep/hotel/icones/imagens/ocupada.png");
		imgPorta.setImage(img);
		
		
	}
	@FXML
	public void mudarOcupado1(ActionEvent event) {
		mniStatus1.setText("Ocupada");
		
		Image img1 = new Image("/br/edu/unisep/hotel/icones/imagens/ocupada.png");
		imgPorta1.setImage(img1);
	}
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	 	
 	

	

}
