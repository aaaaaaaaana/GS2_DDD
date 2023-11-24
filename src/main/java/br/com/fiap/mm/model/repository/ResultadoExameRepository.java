package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.mm.model.entity.Paciente;
import br.com.fiap.mm.model.entity.ResultadoExame;


public class ResultadoExameRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do resultado do exame
	 * @Author M&M
	 * @return null or resultados
	 * */
	
	public static ArrayList<ResultadoExame> findAll() {
		ArrayList<ResultadoExame> resultados = new ArrayList<ResultadoExame>();
		String sql = "select * from resultado_exame";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					ResultadoExame re = new ResultadoExame();
					re.setId(rs.getInt("id_resultado_exame"));
					re.setLaboratorio(rs.getString("laboratorio"));
					re.setExameUrina(rs.getString("ex_urina"));
					re.setExameColesterol(rs.getString("ex_colesterol"));
					re.setExameEletrocardiograma(rs.getString("ex_eletrocadiograma"));
					re.setExameSangue(rs.getString("ex_sangue"));
					
					Paciente paciente = new Paciente();
					paciente.setId(rs.getInt("id_paciente"));
					re.setPaciente(paciente);
					

					
			            resultados.add(re);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar resultados: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return resultados;
		
	}
	
	/**
	 * Método para inserir dados na tabela resultado do exame
	 * @Author M&M
	 * @return null or resultados
	 * */
	
	public static ResultadoExame save(ResultadoExame re) {
		String sql = "insert into agendar_consulta"
				+ "(laboratorio, ex_urina, ex_colesterol, ex_eletrocardiograma, ex_sangue)"
				+ " values(?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, re.getLaboratorio());
			ps.setString(2, re.getExameUrina());
			ps.setString(3, re.getExameColesterol());
			ps.setString(4, re.getExameEletrocardiograma());
			ps.setString(5, re.getExameSangue());
		
			
			
			if (ps.executeUpdate() > 0) {
				return re;
				
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
	

	
}
	