package br.edu.unisep.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unisep.dao.DAOGenerico;
import br.edu.unisep.hotel.vo.ClientesVO;

public class ClientesDAO extends DAOGenerico {
	
	public ClientesDAO() {
	  super ("dbhotel");
	}
	
	public List<ClientesVO>listar() {
		
		List<ClientesVO>listaClientes = new ArrayList<ClientesVO>();
		
		try{
			Connection con = obterConexao();
			
			PreparedStatement ps = con.prepareStatement("select * from schhotel.tb_cliente order by ds_nome asc ");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ClientesVO clientes = new ClientesVO();
				
				Integer id = rs.getInt("id_cliente");
				clientes.setId(id);
				
				String nome = rs.getString("ds_nome");
				clientes.setNome(nome);
				
				String cpf = rs.getString("nr_cpf");
				clientes.setCPF(cpf);
				
				String endereco= rs.getString("ds_endereco");				
				clientes.setEndereco(endereco);
				
				String cidade = rs.getString("ds_cidade");
				clientes.setCidade(cidade);
				
				String rg = rs.getString("nr_rg");
				clientes.setRG(rg);
				
				String telefone = rs.getString("nr_telefone");
				clientes.setTelefone(telefone);
				
				String email = rs.getString("ds_email");
				clientes.setEmail(email);
				
				listaClientes.add(clientes);
			}			
					
			rs.close();
			ps.close();
			con.close();
			
		}catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Clientes: " + e.getMessage());
			e.printStackTrace();
		}
		
		return listaClientes;
	}
	
	public List<ClientesVO> pesquisar (String nome){
		Connection con = obterConexao();
		
		List<ClientesVO>listaCliente = new ArrayList<ClientesVO>();
		
		try{
		PreparedStatement ps = con.prepareStatement("select * from schhotel.tb_cliente where upper(ds_nome)  LIKE '%"
				+ nome.toUpperCase() +"%'" );
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ClientesVO cliente = new ClientesVO();
			
			Integer id = rs.getInt("id_cliente");
			cliente.setId(id);
			
			String nomeCliente = rs.getString("ds_nome");
			cliente.setNome(nomeCliente);
			
			String cpf = rs.getString("nr_cpf");
			cliente.setCPF(cpf);
			
			String endereco= rs.getString("ds_endereco");				
			cliente.setEndereco(endereco);
			
			String cidade = rs.getString("ds_cidade");
			cliente.setCidade(cidade);
			
			String telefone = rs.getString("nr_telefone");
			cliente.setTelefone(telefone);
			
			listaCliente.add(cliente);
		}
		
		rs.close();
		ps.close();
		con.close();
			
		}catch (SQLException e) {
			System.out.println("Erro de SQL - Consulta de Clientes: " + e.getMessage());
			e.printStackTrace();
		}
		return listaCliente;
	}
	
	public void incluir (ClientesVO cliente){
		
		Connection con = obterConexao();
		
		try{
			PreparedStatement ps = con.prepareStatement("insert into schhotel.tb_cliente("
					+ "ds_nome, "
					+ "nr_cpf, "
					+ "ds_endereco, "
					+ "ds_cidade, "
					+ "nr_rg, "
					+ "nr_telefone, "
					+ "ds_email) "
					+ "values"
					+ "(?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCPF());
			ps.setString(3, cliente.getEndereco());
			ps.setString(4, cliente.getCidade());
			ps.setString(5, cliente.getRG());
			ps.setString(6, cliente.getTelefone());
			ps.setString(7, cliente.getEmail());
			
			ps.execute();
			
			ps.close();
			con.close();
					
		} catch (SQLException e) {
			System.out.println("Erro de SQL - No Cadatro de Clientes: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public void excluir(ClientesVO clientes){
		try{
			Connection con = obterConexao();
			
			PreparedStatement ps = con.prepareStatement("delete from schhotel.tb_cliente where id_cliente = ?");
			
			ps.setInt(1,clientes.getId());
			
			ps.execute();
			
			ps.close();
			con.close();
			
		}catch(SQLException e){
			System.out.println("Erro de SQL - Exclusao" + e.getMessage());
			e.printStackTrace();
		}
	}

}
