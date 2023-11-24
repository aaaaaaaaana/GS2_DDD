package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.mm.model.entity.Paciente;
import br.com.fiap.mm.model.entity.Prontuario;

public class ProntuarioRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do Prontuario
	 * @Author M&M
	 * @return null or Prontuarios
	 * */
	
	public static ArrayList<Prontuario> findAll() {
		ArrayList<Prontuario> prontuarios = new ArrayList<Prontuario>();
		String sql = "select * from prontuario";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Prontuario pront = new Prontuario();
					pront.setId(rs.getInt("id_prontuario"));
					pront.setNome(rs.getString("nome_pront"));
					pront.setCpf(rs.getString("cpf_pront"));
					pront.setEtnia(rs.getString("etinia"));
					pront.setGenero(rs.getString("genero"));
					pront.setEmail(rs.getString("email_pront"));
					pront.setTel(rs.getString("telefone"));
					pront.setConvenio(rs.getString("convenio"));
					pront.setEndereco(rs.getString("endereco"));
					pront.setCep(rs.getString("cep"));
					
					Paciente paciente = new Paciente();
					paciente.setId(rs.getInt("id_paciente"));
					pront.setPaciente(paciente);
					
					prontuarios.add(pront);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar prontuario: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return prontuarios;
		
	}
	
	/**
	 * Método para inserir dados na tabela Prontuario
	 * @Author M&M
	 * @return null or Prontuarios
	 * */
	
	public static Prontuario save(Prontuario pront) {
		String sql = "insert into prontuario"
				+ "(nome_pront, cpf_pront, etinia, genero, email_pront, telefone, convenio, endereco, cep)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, pront.getNome());
			ps.setString(2, pront.getCpf());
			ps.setString(3, pront.getEtnia());
			ps.setString(4, pront.getGenero());
			ps.setString(5, pront.getEmail());
			ps.setString(6, pront.getTel());
			ps.setString(7, pront.getConvenio());
			ps.setString(8, pront.getEndereco());
			ps.setString(9, pront.getCep());


			
			
			if (ps.executeUpdate() > 0) {
				return pront;
				
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
	 * Método para atualizar dados na tabela Prontuario
	 * @Author M&M
	 * @return null or Prontuarios
	 * */
	
	public static Prontuario update(Prontuario pront) {
		String sql = "update prontuario"
				+ " set nome_pront = ?, cpf_pront = ?, etinia = ?, genero = ?, email_pront = ?, telefone = ?, convenio = ?, endereco = ?, cep = ?"
				+ " where id_prontuario = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, pront.getId());
			ps.setString(2, pront.getNome());
			ps.setString(3, pront.getCpf());
			ps.setString(4, pront.getEtnia());
			ps.setString(5, pront.getGenero());
			ps.setString(6, pront.getEmail());
			ps.setString(7, pront.getTel());
			ps.setString(8, pront.getConvenio());
			ps.setString(9, pront.getEndereco());
			ps.setString(10, pront.getCep());

	

			if (ps.executeUpdate() > 0) {
				return pront;
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
	 * Método para deletar dados na tabela Prontuario
	 * @Author M&M
	 * @return true or false
	 * */
	
	public static boolean delete(int id) {
		String sql = "delete from prontuario where id_prontuario = ?";
		
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
	