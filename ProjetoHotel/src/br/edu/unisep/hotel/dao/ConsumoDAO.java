package br.edu.unisep.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.dao.DAOGenerico;
import br.edu.unisep.hotel.vo.ConsumoVO;
import br.edu.unisep.hotel.vo.HospedagemVO;
import br.edu.unisep.hotel.vo.ProdutosVO;



public class ConsumoDAO extends DAOGenerico {
	
	public ConsumoDAO(){
		 super ("dbhotel");
	}
	
public List<ConsumoVO> listar(){
		
		List<ConsumoVO>listaConsumo = new ArrayList<ConsumoVO>();
	try{
		Connection con = obterConexao();
		
		PreparedStatement ps = con.prepareStatement("SELECT "
				+ "con.id_consumo, "
				+ "con.vl_total_unitario, "
				+ "con.vl_total, "
				+ "con.qt_consumo, "
				+ "h.id_hospedagem, "
				+ "h.nr_diaria, "
				+ "p.id_produto, "
				+ "p.ds_produto "
				+ "from schhotel.tb_consumo con "
				+ "inner join schhotel.tb_hospedagem h on "
				+ "con.id_consumo = h.id_hospedagem "
				+ "inner join schhotel.tb_produtos p on "
				+ "con.id_consumo = p.id_produto");
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ConsumoVO consumo = new ConsumoVO();
			
			Integer id = rs.getInt("id_consumo");
			consumo.setId(id);
			
			Double valorTotalUnitario = rs.getDouble("vl_total_unitario");
			consumo.setValorTotalUnitario(valorTotalUnitario);
			
			Double valorTotal = rs.getDouble("vl_total");
			consumo.setValorTotal(valorTotal);
			
			Integer quantidade = rs.getInt("qt_consumo");
			consumo.setQuantidadeConsumo(quantidade);
			
			HospedagemVO hospedagem = new HospedagemVO();
			
			Integer idHospedagem = rs.getInt("id_hospedagem");
			hospedagem.setId(idHospedagem);
			
			Integer nrHospedagem = rs.getInt("nr_diaria");
			hospedagem.setDiaria(nrHospedagem);
			
			ProdutosVO produto = new ProdutosVO();
			
			Integer idProduto = rs.getInt("id_produto");
			produto.setId(idProduto);
			
			String dsProduto = rs.getString("ds_produto");
			produto.setProduto(dsProduto);
			
		}
		
		rs.close();
		ps.close();
		con.close();
		
		
	}catch (SQLException e) {
		System.out.println("Erro de SQL - Consulta de Consumo: " + e.getMessage());
		e.printStackTrace();
	}
	
	return listaConsumo;
}

public void salvar(ConsumoVO consumo){
	Connection con = obterConexao();
	
	try{
		PreparedStatement ps = con.prepareStatement("INSERT INTO schhotel.tb_consumo("
				+ "vl_total_unitario, "
				+ "vl_total, "
				+ "qt_consumo, "
				+ "id_produto, "
				+ "id_hospedagem)"
				+ "(VALUES)"
				+ "(?, ?, ?, ?, ?,?)");
		
		ps.setDouble(1, consumo.getValorTotalUnitario());
		ps.setDouble(2, consumo.getValorTotal());
		ps.setInt(3, consumo.getQuantidadeConsumo());
		ps.setInt(4, consumo.getProdutos().getId());
		ps.setInt(5, consumo.getHospedagem().getId());
				
		ps.execute();
		ps.close();
		con.close();
		
							
	} catch (SQLException e) {
		System.out.println("Erro de SQL - Consumo: " + e.getMessage());
		e.printStackTrace();
	}
}

public void excluir(ConsumoVO consumo){
	
	try{
		Connection con = obterConexao();
		
		PreparedStatement ps = con.prepareStatement("delete from schhotel.tb_consumo where id_consumo = ?");
		
		ps.setInt(1,consumo.getId());
		
		ps.execute();
		
		ps.close();
		con.close();
		
	}catch(SQLException e){
		System.out.println("Erro de SQL - Exclusao" + e.getMessage());
		e.printStackTrace();
	}
}

}