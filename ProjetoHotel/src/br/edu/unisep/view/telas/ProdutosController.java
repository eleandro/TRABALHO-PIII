package br.edu.unisep.view.telas;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import br.edu.unisep.hotel.dao.CategoriasProdutosDAO;
import br.edu.unisep.hotel.dao.ProdutosDAO;
import br.edu.unisep.hotel.vo.CategoriaProdutosVO;
import br.edu.unisep.hotel.vo.ProdutosVO;

public class ProdutosController implements Initializable {
	
	public void abrirCategoriasProdutos(ActionEvent event) {
		Stage janela = new Stage();
		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("CategoriaProdutos.fxml"));

			Scene scene = new Scene(root, 335, 430 );
			janela.setScene(scene);
			janela.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private TextField txtProduto;
	
	@FXML
	private TextField txtQuantidade;
	
	@FXML
	private TextField txtValorUnitario;
	
	@FXML
	private ComboBox<CategoriaProdutosVO> cmbCategoria;
	
	private ObservableList<CategoriaProdutosVO>listaCategorias;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		oberteCategorias();
		
	}
	
	
	private void oberteCategorias(){
		CategoriasProdutosDAO dao = new CategoriasProdutosDAO();
 		List<CategoriaProdutosVO>lista = dao.listar();
 		
 		listaCategorias= FXCollections.observableArrayList();
 		listaCategorias.setAll(lista);
 		
 		cmbCategoria.setItems(listaCategorias);
 		
 	}

	
	@FXML public void salvar(ActionEvent event){
		if(!validarCampos()){
			return;
		}
		oberteCategorias();
		
		ProdutosVO produto = new ProdutosVO();
		
		produto.setProduto(txtProduto.getText());
		produto.setCategoriaProduto(cmbCategoria.getValue());
		try{
		Integer quatidade = Integer.parseInt(txtQuantidade.getText());
		produto.setQuantidadeProduto(quatidade);
		}catch(NumberFormatException EX){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtQuantidade.getText() + "'" + " Não é Valido!");
			txtQuantidade.requestFocus();
			return;			
		}
		
		try{
		Double valorUnitarioProduto = Double.parseDouble(txtValorUnitario.getText());
		produto.setValorUnitarioProduto(valorUnitarioProduto);
		}catch(NumberFormatException EX){
			JOptionPane.showMessageDialog(null, "Este Valor " + "'"+ txtValorUnitario.getText() + "'" + " Não é Valido!");
			txtValorUnitario.requestFocus();
			return;			
		}
		
		ProdutosDAO dao = new ProdutosDAO();
 		dao.incluir(produto);
 		
 		txtProduto.setText("");
 		txtQuantidade.setText("");
 		txtValorUnitario.setText("");
 		cmbCategoria.setValue(null);
	}
	
	@FXML public void cancelar(ActionEvent event){
		txtProduto.setText("");
 		txtQuantidade.setText("");
 		txtValorUnitario.setText("");
 		cmbCategoria.setValue(null);
	}
	
	private boolean validarCampos(){
		if(txtProduto.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "O Campo Produto é Obrigatório!");
 			txtProduto.requestFocus();
 			return false;
		}
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
