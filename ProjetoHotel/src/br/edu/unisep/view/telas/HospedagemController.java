package br.edu.unisep.view.telas;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import br.edu.unisep.hotel.dao.ApartamentoDAO;
import br.edu.unisep.hotel.dao.ClientesDAO;
import br.edu.unisep.hotel.dao.HospedagemDAO;
import br.edu.unisep.hotel.vo.ApartamentoVO;
import br.edu.unisep.hotel.vo.ClientesVO;
import br.edu.unisep.hotel.vo.HospedagemVO;


public class HospedagemController implements Initializable {
	
	@FXML 
	private TextField txtContato;
	@FXML 
	private TextField txtValorDiaria;
	@FXML 
	private TextField txtTotalDiaria;
	@FXML
	private DatePicker txtEntrada;
	@FXML	
	private DatePicker txtSaida;
	@FXML
	private TextField txtDiaria;
	@FXML
	private TextArea txtAreaObs;
	@FXML
	private ComboBox<ClientesVO> cmbHospede;
	@FXML
	private ComboBox<ApartamentoVO> cmbCategoria;
	@FXML
	private ComboBox<ApartamentoVO> cmbApartamento;
	
	private ObservableList<ClientesVO> listaHospede;
	private ObservableList<ApartamentoVO> listaApartamento;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		oberteListaApartemento();
		oberteListaHospede();
	
		Bindings.bindBidirectional(txtValorDiaria.textProperty(), txtTotalDiaria.textProperty());
		
	}
	
	private void oberteListaHospede(){
 		ClientesDAO dao = new ClientesDAO();
 		List<ClientesVO>lista = dao.listar();
 		
 		listaHospede = FXCollections.observableArrayList();
 		listaHospede.setAll(lista);
 		
 		cmbHospede.setItems(listaHospede);
 		
 	}
	
 	private void oberteListaApartemento(){
 		ApartamentoDAO dao = new ApartamentoDAO();
 		List<ApartamentoVO>lista = dao.listar();
 		
 		listaApartamento = FXCollections.observableArrayList();
 		listaApartamento.setAll(lista);
 		
 		cmbCategoria.setItems(listaApartamento);
 		cmbApartamento.setItems(listaApartamento);
 	}

 	
 	 	
 	@FXML public void salvar(ActionEvent event){
 		
 		if(!validarCampos()){
 			return;
 		}
 		HospedagemVO hospede = new HospedagemVO();
 		
 		hospede.setContato(txtContato.getText());
 		hospede.setDataEntrada(txtEntrada.getValue());
 		hospede.setDataSaida(txtSaida.getValue());
 		hospede.setCategorias(cmbCategoria.getValue());
 		hospede.setCliente(cmbHospede.getValue());
 		hospede.setObservacao(txtAreaObs.getText());
 		
 		
 		try{
 		Integer diaria = Integer.parseInt(txtDiaria.getText());
 		hospede.setDiaria(diaria);
 		}catch(NumberFormatException EX){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtDiaria.getText() + "'" + " Não é Valido!");
			txtDiaria.requestFocus();
			return;			
		}
 		
 		
 		
 		
 		try{
 			Double valorDiaria = Double.parseDouble(txtValorDiaria.getText());
 	 		hospede.setValorDiaria(valorDiaria);
		}catch(NumberFormatException EX){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtValorDiaria.getText() + "'" + " Não é Valido!");
			txtValorDiaria.requestFocus();
			return;			
		}
 		
 		try{
 			Double totalDiaria = Double.parseDouble(txtTotalDiaria.getText());
 	 		hospede.setTotalDiaria(totalDiaria);
		}catch(NumberFormatException EX){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtTotalDiaria.getText() + "'" + " Não é Valido!");
			txtTotalDiaria.requestFocus();
			return;			
		}
 		
 		
 		
 		
 		HospedagemDAO dao = new HospedagemDAO();
 		dao.salvar(hospede);
 		
 		cmbHospede.setValue(null);
 		cmbCategoria.setValue(null);
 		cmbApartamento.setValue(null);
 		txtContato.setText("");
 		txtEntrada.setValue(null);
 		txtSaida.setValue(null);
 		txtDiaria.setText("");
 		txtAreaObs.setText("");
 		txtValorDiaria.setText("");
 		txtTotalDiaria.setText("");
 		 		 		 		
 	}
 	
 	@FXML
	public void cancelar (ActionEvent event){
 		
 		cmbHospede.setValue(null);
 		cmbCategoria.setValue(null);
 		cmbApartamento.setValue(null);
 		txtContato.setText("");
 		txtEntrada.setValue(null);
 		txtSaida.setValue(null);
 		txtAreaObs.setText("");
 		txtDiaria.setText("");
 		txtValorDiaria.setText("");
 		txtTotalDiaria.setText("");
 	}
 	
 	private boolean validarCampos(){
 		if(txtContato.getText().trim().equals("")){
 			JOptionPane.showMessageDialog(null, "O Campo Contato é Obrigatório!");
 			txtContato.requestFocus();
 			return false;
 		}
 		
 		if(txtEntrada.getEditor().getText().trim().equals("")){
 			JOptionPane.showMessageDialog(null, "O Campo Data de Entrada é Obrigatório!");
 			txtEntrada.requestFocus();
 			return false;
 		}
 		
 		if(txtSaida.getEditor().getText().trim().equals("")){
 			JOptionPane.showMessageDialog(null, "O Campo Data de Saida é Obrigatório!");
 			txtSaida.requestFocus();
 			return false;
 		}
 		
 		if(txtDiaria.getText().trim().equals("")){
 			JOptionPane.showMessageDialog(null, "O Campo Quant. de Diarias é Obrigatório!");
 			txtDiaria.requestFocus();
 			return false;
 		}
 		
 		if(txtValorDiaria.getText().trim().equals("")){
 			JOptionPane.showMessageDialog(null, "O Campo Valor da Diaria é Obrigatório!");
 			txtValorDiaria.requestFocus();
 			return false;
 		}
 		
 		return true;
 	}
 	
 	
}