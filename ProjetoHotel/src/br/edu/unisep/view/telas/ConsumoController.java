package br.edu.unisep.view.telas;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import br.edu.unisep.hotel.dao.ConsumoDAO;
import br.edu.unisep.hotel.dao.HospedagemDAO;
import br.edu.unisep.hotel.dao.ProdutosDAO;
import br.edu.unisep.hotel.vo.ClientesVO;
import br.edu.unisep.hotel.vo.ConsumoVO;
import br.edu.unisep.hotel.vo.HospedagemVO;
import br.edu.unisep.hotel.vo.ProdutosVO;


public class ConsumoController implements Initializable{
	
	@FXML
	private TextField txtValorTotal;
	@FXML
	private TextField txtValorUnitario;
	
	@FXML
	private ComboBox<ProdutosVO> cmbProduto;
	@FXML
	private ComboBox<HospedagemVO> cmbHospedagem;
	@FXML
	private TextField txtQuantidade;
	
	@FXML
	private TextField txtTotalConsumo;
	
	@FXML private TableView <ConsumoVO> tabConsumo;
	
	
	@FXML private TableColumn<ConsumoVO, String> colProduto;
	@FXML private TableColumn<ConsumoVO, Integer> colQuantidade;
	@FXML private TableColumn<ConsumoVO, Double> colvalorUnitario;
	@FXML private TableColumn<ConsumoVO, Double> colValorTotal;
	
	private ObservableList<ProdutosVO> listaProdutos;
	private ObservableList<HospedagemVO> listaHospedagem;
	private ObservableList<ConsumoVO> listaConsumo;
	
	private void obeterListaProdutos(){
		ProdutosDAO dao = new ProdutosDAO();
		List<ProdutosVO> lista = dao.listar();
		
		listaProdutos = FXCollections.observableArrayList();
		listaProdutos.setAll(listaProdutos);
	}

	private void obeterListaHospedagem(){
		HospedagemDAO dao = new HospedagemDAO();
		List<HospedagemVO> lista = dao.listar();
		
		listaHospedagem = FXCollections.observableArrayList();
		listaHospedagem.setAll(lista);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		obeterListaProdutos();
		 obeterListaHospedagem();
		 
		 	ConsumoDAO dao = new ConsumoDAO();
			List<ConsumoVO> lista = dao.listar();		
			
			listaConsumo = FXCollections.observableArrayList(lista);
			
			colProduto.setCellValueFactory(new PropertyValueFactory<ConsumoVO, String>("hospedagem"));
			colQuantidade.setCellValueFactory(new PropertyValueFactory<ConsumoVO, Integer>("quantidadeConsumo"));
			colvalorUnitario.setCellValueFactory(new PropertyValueFactory<ConsumoVO, Double>("valorTotalUnitario"));
			colValorTotal.setCellValueFactory(new PropertyValueFactory<ConsumoVO, Double>("valorTotal"));
			
			tabConsumo.setItems(listaConsumo);
		 
	}
	
	@FXML
	public void finalizar(ActionEvent event){
		
		if(!validarCampos()){
			return;
		}
		
		ConsumoVO consumo = new ConsumoVO();
		
		consumo.setHospedagem(cmbHospedagem.getValue());
		consumo.setProdutos(cmbProduto.getValue());
		try{
		Integer quantidade = Integer.parseInt(txtQuantidade.getText());
		consumo.setQuantidadeConsumo(quantidade);
		}catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtQuantidade.getText() + "'" + " Não é Valido!");
			txtQuantidade.requestFocus();
			return;		
		}
		
		try{
 			Double valorUnitario = Double.parseDouble(txtValorUnitario.getText());
 	 		consumo.setValorTotalUnitario(valorUnitario);;
		}catch(NumberFormatException EX){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtValorUnitario.getText() + "'" + " Não é Valido!");
			txtValorUnitario.requestFocus();
			return;			
		}
		
		try{
 			Double valorTotal = Double.parseDouble(txtValorTotal.getText());
 	 		consumo.setValorTotal(valorTotal);
		}catch(NumberFormatException EX){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtValorUnitario.getText() + "'" + " Não é Valido!");
			txtTotalConsumo.requestFocus();
			return;			
		}
		
		ConsumoDAO dao = new ConsumoDAO();
		dao.salvar(consumo);
		
		cmbHospedagem.setValue(null);
		cmbProduto.setValue(null);
		txtQuantidade.setText("");
		txtValorUnitario.setText("");
		txtValorTotal.setText("");
		
		
	}
	
	@FXML
	public void cancelar(ActionEvent event){
		cmbHospedagem.setValue(null);
		cmbProduto.setValue(null);
		txtQuantidade.setText("");
		txtValorUnitario.setText("");
		txtValorTotal.setText("");
	}
	@FXML
	public void excluir(ActionEvent event){		
	
		
		ConsumoVO consumo = tabConsumo.getSelectionModel().getSelectedItem();
		
		if(consumo != null){
			ConsumoDAO dao = new ConsumoDAO();
			dao.excluir(consumo);
			
			List<ConsumoVO> lista = dao.listar();
			listaConsumo.setAll(lista);
		}
	}
	
	private boolean validarCampos(){
		if(txtQuantidade.getText().trim().equals("")){
 			JOptionPane.showMessageDialog(null, "O Campo Quantidade é Obrigatório!");
 			txtQuantidade.requestFocus();
 			return false;
 		}
		
		if(txtValorUnitario.getText().trim().equals("")){
 			JOptionPane.showMessageDialog(null, "O Campo Valor Unitario é Obrigatório!");
 			txtValorUnitario.requestFocus();
 			return false;
 		}
		
		
		return true;
	}
}
