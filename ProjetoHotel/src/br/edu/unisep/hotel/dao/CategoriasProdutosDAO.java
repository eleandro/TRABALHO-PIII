package br.edu.unisep.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.dao.DAOGenerico;
import br.edu.unisep.hotel.vo.CategoriaProdutosVO;


public class CategoriasProdutosDAO extends DAOGenerico {
	
	public CategoriasProdutosDAO(){
		 super ("dbhotel");
	}
	
	public List<CategoriaProdutosVO> listar(){
		
		List<CategoriaProdutosVO>listaCategorias = new ArrayList<CategoriaProdutosVO>();
		
		try{
			Connection con = obterConexao();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM schhotel.tb_categoria_produto ");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CategoriaProdutosVO categoria = new CategoriaProdutosVO();
				
				Integer id = rs.getInt("id_categoria_produto");
				categoria.setId(id);
				
				String categorias = rs.getString("ds_categoria");
				categoria.setCategoria(categorias);
			}
			
			rs.close();
			ps.close();
			con.close();
			
		}catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Categorias de Produtos: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaCategorias;
	}
	
	public void salvar (CategoriaProdutosVO categorias){
		
		Connection con = obterConexao();
		
		try{
			PreparedStatement ps = con.prepareStatement("insert into schhotel.tb_categoria_produto("
					+ "ds_categoria)"
					+ "values"
					+ "(?)");
			
			ps.setString(1, categorias.getCategoria());
			
			ps.execute();
			
			ps.close();
			con.close();
		
	} catch (SQLException e) {
		System.out.println("Erro de SQL - No Cadatro de Categorias de Produtos: " + e.getMessage());
		e.printStackTrace();
	}

	}
	

public void excluir(CategoriaProdutosVO categorias){
	
	try{
		Connection con = obterConexao();
		
		PreparedStatement ps = con.prepareStatement("delete from schhotel.tb_categoria_produto where  id_categoria_produto = ?");
		
		ps.setInt(1,categorias.getId());
		
		ps.execute();
		
		ps.close();
		con.close();
		
	}catch(SQLException e){
		System.out.println("Erro de SQL - Exclusao" + e.getMessage());
		e.printStackTrace();
	}
}
}