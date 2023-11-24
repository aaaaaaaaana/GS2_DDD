package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.AgendaExame;
import br.com.fiap.mm.model.entity.Paciente;

public class AgendaExameRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do AgendaExame
	 * @Author M&M
	 * @return null or Exames
	 * */
	
	public static ArrayList<AgendaExame> findAll() {
		ArrayList<AgendaExame> exames = new ArrayList<AgendaExame>();
		String sql = "select * from agendar_exame";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					AgendaExame ae = new AgendaExame();
					ae.setId(rs.getInt("id_agendar_exame"));
					ae.setTipo(rs.getString("tipo_exame"));
					ae.setLaboratorio(rs.getString("laboratorio"));
					ae.setDataHora(rs.getTimestamp("data_hora_exame"));
					
					
					Paciente paciente = new Paciente();
					paciente.setId(rs.getInt("id_paciente"));
					ae.setPaciente(paciente);
					
					
					
					exames.add(ae);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar exames: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return exames;
		
	}
	
	/**
	 * Método para inserir dados na tabela AgendaExame
	 * @Author M&M
	 * @return null or Exames
	 * */
	
	public static AgendaExame save(AgendaExame ae) {
		String sql = "insert into agendar_exame"
				+ "(tipo_exame, laboratorio, data_hora_exame)"
				+ " values(?, ?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, ae.getTipo());
			ps.setString(2, ae.getLaboratorio());
			ps.setTimestamp(3, ae.getDataHora());


			
			
			if (ps.executeUpdate() > 0) {
				return ae;
				
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
	 * Método para atualizar dados na tabela AgendaExame
	 * @Author M&M
	 * @return null or Exames
	 * */
	
	public static AgendaExame update(AgendaExame ae) {
		String sql = "update agendar_exame"
				+ " set tipo_exame = ?, laboratorio = ?, data_hora_exame = ?"
				+ " where id_agendar_exame = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, ae.getId());
			ps.setString(2, ae.getTipo());
			ps.setString(3, ae.getLaboratorio());
			ps.setTimestamp(4, ae.getDataHora());
			
			

			if (ps.executeUpdate() > 0) {
				return ae;
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
	 * Método para deletar dados na tabela AgendaExame
	 * @Author M&M
	 * @return true or false
	 * */
	
	public static boolean delete(int id) {
		String sql = "delete from agendar_exame where id_agendar_exame = ?";
		
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