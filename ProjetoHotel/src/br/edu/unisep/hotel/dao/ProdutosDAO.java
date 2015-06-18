package br.edu.unisep.hotel.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.dao.DAOGenerico;
import br.edu.unisep.hotel.vo.CategoriaProdutosVO;
import br.edu.unisep.hotel.vo.ProdutosVO;

public class ProdutosDAO  extends DAOGenerico {
	
	public  ProdutosDAO() {
		  super ("dbhotel");
		}
	
public List<ProdutosVO>listar(){
		
		List<ProdutosVO>listaProdutos = new ArrayList<ProdutosVO>();
		
		try{
			Connection con = obterConexao();
			
			PreparedStatement ps = con.prepareStatement("select "
					+ "p.id_produto, "
					+ "p.ds_produto, "
					+ "p.vl_unt_produto, "
					+ "p.qt_produto, "
					+ "cat.id_categoria_produto, "
					+ "cat.ds_categoria "
					+ "from schhotel.tb_produtos p "
					+ "inner join schhotel.tb_categoria_produto cat on "
					+ "p.id_categoria_produto = cat.id_categoria_produto ");
					
			
					
			ResultSet rs = ps.executeQuery();		
			
			while (rs.next()){
				ProdutosVO produto = new ProdutosVO();
				
				Integer id = rs.getInt("id_produto");
				produto.setId(id);
				
				String dsProduto = rs.getString("ds_produto");
				produto.setProduto(dsProduto);
				
				Double valorUnitario = rs.getDouble("vl_unt_produto");
				produto.setValorUnitarioProduto(valorUnitario);
				
				Integer quantidade = rs.getInt("qt_produto");
				produto.setQuantidadeProduto(quantidade);
								
								
				CategoriaProdutosVO categoriaP = new CategoriaProdutosVO();
												
				Integer idCat = rs.getInt("id_categoria_produto");
				categoriaP.setId(idCat);
				
				String cat = rs.getString("ds_categoria");
			    categoriaP.setCategoria(cat);
			    
			   					
				produto.setCategoriaProduto(categoriaP);
								
				
								
				listaProdutos.add(produto);
				
			}
			
			rs.close();
			ps.close();
			con.close();
					

		}catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Produtos: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaProdutos;
	}
	
	public void incluir (ProdutosVO produto){
		
		Connection con = obterConexao();
		
		try{
			PreparedStatement ps = con.prepareStatement("INSERT INTO schhotel.tb_produtos("
					+ "ds_produto, "
					+ "vl_unt_produto, "
					+ "qt_produto, "
					+ "id_categoria_produto) "
					+ "values"
					+ "(?, ?, ?, ?)");
			
			ps.setString(1, produto.getProduto());
			ps.setDouble(2, produto.getValorUnitarioProduto());
			ps.setInt(3, produto.getQuantidadeProduto());
			ps.setInt(4, produto.getCategoriaProduto().getId());
			
			ps.execute();
			
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - No Cadatro de Produtos: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}

}
