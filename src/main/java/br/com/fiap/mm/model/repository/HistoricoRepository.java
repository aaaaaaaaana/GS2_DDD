package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.Historico;
import br.com.fiap.mm.model.entity.Paciente;

public class HistoricoRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do historico
	 * @Author M&M
	 * @return null or historicos
	 * */
	
	public static ArrayList<Historico> findAll() {
		ArrayList<Historico> historicos = new ArrayList<Historico>();
		String sql = "select * from historico";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Historico hist = new Historico();
					hist.setId(rs.getInt("id_historico"));
					hist.setFebre(rs.getString("febre"));
					hist.setAlcool(rs.getString("alcool"));
					hist.setAlergia(rs.getString("alergias"));
					hist.setAntibioticos(rs.getString("antibioticos"));
					hist.setMedicamentos(rs.getString("medicamentos"));
					hist.setDoencas(rs.getString("doenca_presente"));
					hist.setCardio(rs.getString("doenca_coracao"));
					hist.setFumo(rs.getString("fumante"));
					hist.setDiabetes(rs.getString("diabetes"));
					hist.setCicatrizacao(rs.getString("cicatrizacao"));
					hist.setGravidez(rs.getString("gravidez"));
					hist.setImplantes(rs.getString("implantes"));

					Paciente paciente = new Paciente();
					paciente.setId(rs.getInt("id_paciente"));
					hist.setPaciente(paciente);
					

					
					historicos.add(hist);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar usuario: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return historicos;
		
	}
	
	/**
	 * Método para inserir dados na tabela historico
	 * @Author M&M
	 * @return null or historicos
	 * */
	
	public static Historico save(Historico hist) {
		String sql = "insert into historico"
				+ "(febre, alcool, alergias, antibioticos, medicamentos, doenca_presente, doenca_coracao,"
				+ " fumante, diabetes, cicatrizacao, gravidez, implantes)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, hist.getFebre());
			ps.setString(2, hist.getAlcool());
			ps.setString(3, hist.getAlergia());
			ps.setString(4, hist.getAntibioticos());
			ps.setString(5, hist.getMedicamentos());
			ps.setString(6, hist.getDoencas());
			ps.setString(7, hist.getCardio());
			ps.setString(8, hist.getFumo());
			ps.setString(9, hist.getDiabetes());
			ps.setString(10, hist.getCicatrizacao());
			ps.setString(11, hist.getGravidez());
			ps.setString(12, hist.getImplantes());

			
			
			if (ps.executeUpdate() > 0) {
				return hist;
				
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
	 * Método para atualizar dados na tabela historico
	 * @Author M&M
	 * @return null or historicos
	 * */
	
	public static Historico update(Historico hist) {
		String sql = "update historico"
				+ " set febre = ?, alcool = ?, alergias = ?, antibioticos = ?, medicamentos = ?, doenca_presente = ?, doenca_coracao = ?, fumante = ?, diabetes = ?, cicatrizacao = ?, gravidez = ?, implantes = ?"
				+ " where id_historico = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, hist.getFebre());
			ps.setString(2, hist.getAlcool());
			ps.setString(3, hist.getAlergia());
			ps.setString(4, hist.getAntibioticos());
			ps.setString(5, hist.getMedicamentos());
			ps.setString(6, hist.getDoencas());
			ps.setString(7, hist.getCardio());
			ps.setString(8, hist.getFumo());
			ps.setString(9, hist.getDiabetes());
			ps.setString(10, hist.getCicatrizacao());
			ps.setString(11, hist.getGravidez());
			ps.setString(12, hist.getImplantes());
			ps.setInt(13, hist.getId());

			

			if (ps.executeUpdate() > 0) {
				return hist;
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
	 * Método para deletar dados na tabela historico
	 * @Author M&M
	 * @return true or false
	 * */
	
	public static boolean delete(int id) {
		String sql = "delete from historico where id_historico = ?";
		
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