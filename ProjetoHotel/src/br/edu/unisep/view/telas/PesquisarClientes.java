package br.edu.unisep.view.telas;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import br.edu.unisep.hotel.dao.ClientesDAO;
import br.edu.unisep.hotel.vo.ClientesVO;



public class PesquisarClientes implements Initializable{
	
	@FXML private TextField txtNome;
	
	@FXML private TableView <ClientesVO> tabClientes;
	
	@FXML private TableColumn<ClientesVO, String> colNome;
	@FXML private TableColumn<ClientesVO, String> colCPF;
	@FXML private TableColumn<ClientesVO, String> colEndereco;
	@FXML private TableColumn<ClientesVO, String> colCidade;
	@FXML private TableColumn<ClientesVO, String> colTelefone;
	
	private ObservableList<ClientesVO>listaClientes;
	
	public void pesquisar(ActionEvent event){
		
		ClientesDAO dao = new ClientesDAO();
							
		List<ClientesVO> pesquisar = dao.pesquisar(txtNome.getText());
		listaClientes.setAll(pesquisar);
				
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ClientesDAO dao = new ClientesDAO();
		List<ClientesVO> lista = dao.listar();		
		
		listaClientes = FXCollections.observableArrayList(lista);
		
		colNome.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("nome"));
		colCPF.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("CPF"));
		colEndereco.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("endereco"));
		colCidade.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("cidade"));
		colTelefone.setCellValueFactory(new PropertyValueFactory<ClientesVO, String>("telefone"));
		
		tabClientes.setItems(listaClientes);
	}
	

}
