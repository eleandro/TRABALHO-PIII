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

import javax.swing.JOptionPane;
import br.edu.unisep.hotel.dao.CategoriasProdutosDAO;
import br.edu.unisep.hotel.vo.CategoriaProdutosVO;


public class CategoriasProdutosController implements Initializable{ 
	
	@FXML
	private TableView<CategoriaProdutosVO> tabCategoria;
	

	@FXML
	private TableColumn<CategoriaProdutosVO, String> colCategoria;
	
	@FXML
	private TextField txtCategorias;
	
	private ObservableList<CategoriaProdutosVO>listaCategorias;
	
	@FXML
	public void salvar(ActionEvent event){
		if(!validarCampos()){
			return;
		}
		CategoriaProdutosVO categorias = new CategoriaProdutosVO();
		
		categorias.setCategoria(txtCategorias.getText());
		
		CategoriasProdutosDAO dao = new CategoriasProdutosDAO();
 		dao.salvar(categorias);
 		
 		txtCategorias.setText("");
	}
	
	@FXML
	public void excluir(ActionEvent event){		
	
		
		CategoriaProdutosVO categorias = tabCategoria.getSelectionModel().getSelectedItem();
		
		if(categorias != null){
			CategoriasProdutosDAO dao = new CategoriasProdutosDAO();
			dao.excluir(categorias);
			
			List<CategoriaProdutosVO > lista = dao.listar();
			listaCategorias.setAll(lista);
		}
	}
	
	private boolean validarCampos(){
		if(txtCategorias.getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "O Campo Categoria é Obrigatório");
			txtCategorias.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CategoriasProdutosDAO dao = new CategoriasProdutosDAO();
		
		List<CategoriaProdutosVO> lista = dao.listar();
		
		listaCategorias = FXCollections.observableArrayList(lista);
		
		colCategoria.setCellValueFactory(new PropertyValueFactory<CategoriaProdutosVO, String>("categoria"));
		
		tabCategoria.setItems(listaCategorias);
	}
}
