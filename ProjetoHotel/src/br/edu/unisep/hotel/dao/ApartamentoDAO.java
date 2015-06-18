package br.edu.unisep.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.dao.DAOGenerico;
import br.edu.unisep.hotel.vo.ApartamentoVO;

public class ApartamentoDAO extends DAOGenerico {
	
	public ApartamentoDAO() {
		  super ("dbhotel");
		}
	
	public List<ApartamentoVO>listar() {
	
		List<ApartamentoVO>listaApartamento = new ArrayList<ApartamentoVO>();
		
		try{
			Connection con = obterConexao();
			
			PreparedStatement ps = con.prepareStatement("select * from schhotel.tb_apartamento"
					);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ApartamentoVO apartamento= new ApartamentoVO();
				
				Integer id = rs.getInt("id_apartamento");
				apartamento.setId(id);
				
				String categoria = rs.getString("ds_categoria");
				apartamento.setCategoria(categoria);
				
				String obs = rs.getString("ds_observacao");
				apartamento.setObservacao(obs);
				
				String capacidade = rs.getString("ds_capacidade");
				apartamento.setCapacidade(capacidade);
												
				listaApartamento.add(apartamento);
				
			}			
					
			rs.close();
			ps.close();
			con.close();
			
		}catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Apartamento: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaApartamento;
	}
	
public void Salvar (ApartamentoVO apartamento){
		
		Connection con = obterConexao();
		
		try{
			PreparedStatement ps = con.prepareStatement("insert into schhotel.tb_apartamento("
					+ "nr_apartamento, "
					+ "ds_categoria, "
					+ "ds_capacidade, "				
					+ "ds_observacao) "
					+ "values"
					+ "(?, ?, ?, ?)");
			
			ps.setString(1, apartamento.getNumeroApartamento());
			ps.setString(2, apartamento.getCategoria());			
			ps.setString(3, apartamento.getCapacidade());	
			ps.setString(4, apartamento.getObservacao());
				
			
			ps.execute();
			
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - No Cadatro de Apartamento: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	

}
