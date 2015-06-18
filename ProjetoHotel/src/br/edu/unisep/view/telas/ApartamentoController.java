package br.edu.unisep.view.telas;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import br.edu.unisep.hotel.dao.ApartamentoDAO;
import br.edu.unisep.hotel.vo.ApartamentoVO;


public class ApartamentoController implements Initializable{
	
	@FXML
	private TextField txtApartamento;
	@FXML
	private TextField txtCategoria;
	@FXML
	private TextField txtCapacidade;
		
	@FXML
	private TextArea txtAreaObs;
	
	private ApartamentoVO apartamento;
	
	
@FXML public void salvar(ActionEvent event){
	
	if(!validarCampos()){
	return;
	}
		
	this.apartamento = new ApartamentoVO();
	
	Bindings.bindBidirectional(txtApartamento.textProperty(), apartamento.numeroApartamentoProperty());
	Bindings.bindBidirectional(txtCategoria.textProperty(), apartamento.categoriaProperty());
	Bindings.bindBidirectional(txtCapacidade.textProperty(), apartamento.capacidadeProperty());
	Bindings.bindBidirectional(txtAreaObs.textProperty(), apartamento.observacaoProperty());
	
	ApartamentoDAO dao = new ApartamentoDAO();
	dao.Salvar(apartamento);
		
	
}

@FXML
public void cancelar (ActionEvent event){
	
	txtApartamento.setText("");
	txtCategoria.setText("");
	txtCapacidade.setText("");
	txtAreaObs.setText("");	
	txtApartamento.requestFocus();
}


@Override
public void initialize(URL location, ResourceBundle resources) {
	
}

private boolean validarCampos(){	 
		
	if(txtApartamento.getText().trim().equals("")){
		JOptionPane.showMessageDialog(null, "O Campo Apartamento é Obrigatório!");
		txtApartamento.requestFocus();
		return false;
	}
	if(txtCategoria.getText().trim().equals("")){
		JOptionPane.showMessageDialog(null, "O Campo Categoria é Obrigatório!");
		txtCategoria.requestFocus();
		return false;
	
	}
	
	if(txtCapacidade.getText().trim().equals("")){
		JOptionPane.showMessageDialog(null, "O Campo Capacidade é Obrigatório!");
		txtCapacidade.requestFocus();
		return false;
	
	}
	return true;
   
}
}