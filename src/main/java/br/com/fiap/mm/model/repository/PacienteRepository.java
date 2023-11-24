package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.Paciente;
import br.com.fiap.mm.model.entity.Robo;


public class PacienteRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do paciente
	 * @Author M&M
	 * @return null or pacientes
	 * */
	
	public static ArrayList<Paciente> findAll() {
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		String sql = "select * from paciente";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Paciente pac = new Paciente();
					pac.setId(rs.getInt("id_paciente"));
					pac.setNome(rs.getString("nome_paciente"));
					pac.setCpf(rs.getString("cpf_paciente"));
					
					Robo robo = new Robo();
					robo.setId(rs.getInt("id_robo"));
					pac.setRobo(robo);
					

					
					pacientes.add(pac);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar paciente: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return pacientes;
		
	}
	
	/**
	 * Método para inserir dados na tabela paciente
	 * @Author M&M
	 * @return null or pacientes
	 * */
	
	public static Paciente save(Paciente pac) {
		String sql = "insert into paciente"
				+ "(nome_paciente, cpf_paciente)"
				+ " values(?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, pac.getNome());
			ps.setString(2, pac.getCpf());

			
			
			if (ps.executeUpdate() > 0) {
				return pac;
				
			} else {
				return null;
			}
				
		} catch (SQLException e) {
				System.out.println("Erro ao salvar: " + e.getMessage());
				
		} finally {
			closeConnection();
		}
		return null;
		
	}
	
	
	/**
	 * Método para atualizar dados na tabela paciente
	 * @Author M&M
	 * @return null or pacientes
	 * */
	
	public static Paciente update(Paciente pac) {
		String sql = "update paciente"
				+ " set nome_paciente = ?, cpf_paciente = ?"
				+ " where id_paciente = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, pac.getId());
			ps.setString(2, pac.getNome());
			ps.setString(4, pac.getCpf());


	

			if (ps.executeUpdate() > 0) {
				return pac;
			} else {				
				return null;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar: " + e.getMessage());
		} finally {
			closeConnection();
		}
		return null;
	}
	
	
}
	