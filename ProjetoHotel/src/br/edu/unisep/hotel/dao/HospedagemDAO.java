package br.edu.unisep.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.dao.DAOGenerico;
import br.edu.unisep.hotel.vo.ApartamentoVO;
import br.edu.unisep.hotel.vo.ClientesVO;
import br.edu.unisep.hotel.vo.HospedagemVO;

public class HospedagemDAO extends DAOGenerico {
	
		public HospedagemDAO() {
		  super ("dbhotel");
		}
		
	public List<HospedagemVO>listar(){
		
		List<HospedagemVO>listaHospedagem = new ArrayList<HospedagemVO>();
		
		try{
			Connection con = obterConexao();
			
			PreparedStatement ps = con.prepareStatement("select "
					+ "h.id_hospedagem, "
					+ "h.dt_entrada, "
					+ "h.dt_saida, "
					+ "h.ds_observacao, "
					+ "h.nr_diaria, "
					+ "h.vl_total_diaria, "
					+ "h.vl_diaria,"
					+ "h.id_cliente, "
					+ "a.id_apartamento, "
					+ "a.ds_categoria,"
					+ "a.nr_apartamento, "
				    + "c.id_cliente, "
				    + "c.ds_nome "
					+ "from schhotel.tb_hospedagem h "
					+ "inner join schhotel.tb_apartamento a on "
					+ "h.id_apartamento = a.id_apartamento "
					+ "inner join schhotel.tb_cliente c on "
					+ "h.id_cliente = c.id_cliente");
					
			ResultSet rs = ps.executeQuery();		
			
			while (rs.next()){
				HospedagemVO hospede = new HospedagemVO();
				
				Integer id = rs.getInt("id_hospedagem");
				hospede.setId(id);
				
				Date dataEntrada = rs.getDate("dt_entrada");
				hospede.setDataEntrada(dataEntrada.toLocalDate());
				
				Date dataSaida = rs.getDate("dt_saida");
				hospede.setDataSaida(dataSaida.toLocalDate());
						
								
				String obs = rs.getString("ds_observacao");
				hospede.setObservacao(obs);
								
				Integer diaria = rs.getInt("nr_diaria");
				hospede.setDiaria(diaria);
											
				Double totalDiaria = rs.getDouble("vl_total_diaria");
				hospede.setTotalDiaria(totalDiaria);
				
				Double valorDiaria = rs.getDouble("vl_diaria");
				hospede.setValorDiaria(valorDiaria);
				
				ApartamentoVO categorias = new ApartamentoVO();
												
				Integer idApartamento = rs.getInt("id_apartamento");
				categorias.setId(idApartamento);
				
				String categoria = rs.getString("ds_categoria");
			    categorias.setCategoria(categoria);
			    
			   String numeroApartamento = rs.getString("nr_apartamento");
			   categorias.setNumeroApartamento(numeroApartamento);
				    
								
				ClientesVO cliente = new ClientesVO();
				
				Integer idCliente = rs.getInt("id_cliente");
				cliente.setId(idCliente);
				
				String nome = rs.getString("ds_nome");
				cliente.setNome(nome);
				
					
				hospede.setCategorias(categorias);
								
				hospede.setCliente(cliente);
				
				listaHospedagem.add(hospede);
				
			}
			
			rs.close();
			ps.close();
			con.close();
					

		}catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Hopedagens: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaHospedagem;
	}
	
	
	public List<HospedagemVO> pesquisar (Date dtinicial, Date dtfinal){
		Connection con = obterConexao();
		
    List<HospedagemVO>listaHospedagem = new ArrayList<HospedagemVO>();
		
		try{
			PreparedStatement ps = con.prepareStatement("select * from schhotel.tb_hospedagem where (dt_saida between ? and ?) "
					+ "or (dt_entrada between ? and ?) " );
			
		
			ps.setDate(1, dtinicial);
			ps.setDate(2, dtfinal);
			ps.setDate(3, dtinicial);
			ps.setDate(4, dtfinal);
            
              ResultSet rs = ps.executeQuery();		
			
			while (rs.next()){
				HospedagemVO hospede = new HospedagemVO();
				
				Integer id = rs.getInt("id_apartamento");
				hospede.setId(id);
				
				Date dataE = rs.getDate("dt_entrada");
				hospede.setDataEntrada(dataE.toLocalDate());
				
				Date dataS = rs.getDate("dt_saida");
				hospede.setDataSaida(dataS.toLocalDate());
				
				Integer diaria = rs.getInt("nr_diaria");
				hospede.setDiaria(diaria);
				
				rs.close();
				ps.close();
				con.close();
			}
		}catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Hospedagem: " + e.getMessage());
			e.printStackTrace();
	}
		return listaHospedagem;
	}	
	
	public void salvar(HospedagemVO hospede){
		Connection con = obterConexao();
		
		try{
			PreparedStatement ps = con.prepareStatement("insert into schhotel.tb_hospedagem("
					+ "id_cliente, "
					+ "ds_contato, "
					+ "dt_entrada, "
					+ "dt_saida, "
					+ "id_apartamento, "
					+ "nr_diaria,"
					+ "ds_observacao, "
					+ "vl_diaria, "
					+ "vl_total_diaria)"			
					+ "values"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			ps.setInt(1, hospede.getCliente().getId());
			ps.setString(2, hospede.getContato());
			ps.setString(2, hospede.getContato());
			Date entrada = Date.valueOf(hospede.getDataEntrada());
			ps.setDate(3, entrada);	
			Date saida = Date.valueOf(hospede.getDataSaida());
			ps.setDate(4, saida);
			ps.setInt(5, hospede.getCategorias().getId());
			ps.setInt(6, hospede.getDiaria());			
			ps.setString(7, hospede.getObservacao());
			ps.setDouble(8, hospede.getValorDiaria());			
			ps.setDouble(9, hospede.getTotalDiaria());
			
			ps.execute();
			ps.close();
			con.close();
			
								
		} catch (SQLException e) {
			System.out.println("Erro de SQL - Reserva de Hospede: " + e.getMessage());
			e.printStackTrace();
		}
	}


}
