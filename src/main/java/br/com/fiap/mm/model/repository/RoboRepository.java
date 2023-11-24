package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.Robo;
import br.com.fiap.mm.model.entity.Instituicao;


public class RoboRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do robo
	 * @Author M&M
	 * @return null or robos
	 * */
	
	public static ArrayList<Robo> findAll() {
		ArrayList<Robo> robos = new ArrayList<Robo>();
		String sql = "select * from robo";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Robo rb = new Robo();
					rb.setId(rs.getInt("id_robo"));
					rb.setNumSerie(rs.getInt("funcao"));
					rb.setFuncao(rs.getString("num_serie"));
					
					Instituicao instituicao = new Instituicao();
					instituicao.setId(rs.getInt("id_instituicao"));
					rb.setInstituicao(instituicao);
					
					
					robos.add(rb);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar robo: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return robos;
		
	}
	
	/**
	 * Método para inserir dados na tabela robo
	 * @Author M&M
	 * @return null or robos
	 * */
	
	public static Robo save(Robo rb) {
		String sql = "insert into robo"
				+ "(funcao, num_serie)"
				+ " values(?, ?=)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setInt(1, rb.getNumSerie());
			ps.setString(2, rb.getFuncao());


			
			
			if (ps.executeUpdate() > 0) {
				return rb;
				
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
	 * Método para atualizar dados na tabela robo
	 * @Author M&M
	 * @return null or robos
	 * */
	
	public static Robo update(Robo rb) {
		String sql = "update robo"
				+ " set, funcao = ?, num_serie = ?, id_instituicao = ?"
				+ " where id_robo = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, rb.getId());
			ps.setInt(2, rb.getNumSerie());
			ps.setString(3, rb.getFuncao());
			ps.setObject(4, rb.getInstituicao());
	

			if (ps.executeUpdate() > 0) {
				return rb;
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
	 * Método para deletar dados na tabela robos
	 * @Author M&M
	 * @return true or false
	 * */
	
	public static boolean delete(int id) {
		String sql = "delete from robo where id_robo = ?";
		
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