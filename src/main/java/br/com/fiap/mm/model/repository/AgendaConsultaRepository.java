package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.AgendaConsulta;
import br.com.fiap.mm.model.entity.Paciente;

public class AgendaConsultaRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do AgendaConsulta
	 * @Author M&M
	 * @return null or consultas
	 * */
	
	public static ArrayList<AgendaConsulta> findAll() {
		ArrayList<AgendaConsulta> consultas = new ArrayList<AgendaConsulta>();
		String sql = "select * from agendar_consulta";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					AgendaConsulta ac = new AgendaConsulta();
					ac.setId(rs.getInt("id_agendar_consulta"));
					ac.setEspecialidade(rs.getString("especialidade"));
					ac.setLocal(rs.getString("lugar"));
					ac.setDataHora(rs.getTimestamp("data_hora_consulta"));
					
					Paciente paciente = new Paciente();
					paciente.setId(rs.getInt("id_paciente"));
					ac.setPaciente(paciente);
					
					
					consultas.add(ac);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar Checkup: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return consultas;
		
	}
	
	/**
	 * Método para inserir dados na tabela AgendaConsulta
	 * @Author M&M
	 * @return null or consultas
	 * */
	
	public static AgendaConsulta save(AgendaConsulta ac) {
		String sql = "insert into agendar_consulta"
				+ "(especialidade, lugar, data_hora_consulta)"
				+ " values(?, ?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, ac.getEspecialidade());
			ps.setString(2, ac.getLocal());
			ps.setTimestamp(3, ac.getDataHora());


			
			if (ps.executeUpdate() > 0) {
				return ac;
				
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
	 * Método para atualizar dados na tabela AgendaConsulta
	 * @Author M&M
	 * @return null or consultas
	 * */
	
	public static AgendaConsulta update(AgendaConsulta ac) {
		String sql = "update agendar_consulta"
				+ " set especialidade = ?, lugar = ?, data_hora_consulta = ?"
				+ " where id_agendar_consulta = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, ac.getId());
			ps.setString(2, ac.getEspecialidade());
			ps.setString(3, ac.getLocal());
			ps.setTimestamp(4, ac.getDataHora());
		
	

			if (ps.executeUpdate() > 0) {
				return ac;
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
	
	/**
	 * Método para deletar dados na tabela AgendaConsulta
	 * @Author M&M
	 * @return true or false
	 * */
	
	public static boolean delete(int id) {
		String sql = "delete from agendar_consulta where id_agendar_consulta = ?";
		
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao excluir: " + e.getMessage());
		} finally {
			closeConnection();
		} return false;
	} 

	
}