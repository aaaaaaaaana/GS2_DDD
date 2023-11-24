package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.Usuario;

public class UsuarioRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do usuario
	 * @Author M&M
	 * @return null or usuarios
	 * */
	
	public static ArrayList<Usuario> findAll() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "select * from usuario";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Usuario us = new Usuario();
					us.setId(rs.getInt("id_usuario"));
					us.setEmail(rs.getString("email_usuario"));
					us.setCpf(rs.getString("cpf_usuario"));
					us.setSenha(rs.getString("senha"));
					
					

					
					usuarios.add(us);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar usuario: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return usuarios;
		
	}
	
	/**
	 * Método para inserir dados na tabela usuario
	 * @Author M&M
	 * @return null or usuarios
	 * */
	
	public static Usuario save(Usuario us) {
		String sql = "insert into usuario"
				+ "(email_usuario, cpf_usuario, senha)"
				+ " values(?, ?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getCpf());
			ps.setString(3, us.getSenha());

			
			
			if (ps.executeUpdate() > 0) {
				return us;
				
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
	 * Método para atualizar dados na tabela usuario
	 * @Author M&M
	 * @return null or usuarios
	 * */
	
	public static Usuario update(Usuario us) {
		String sql = "update usuario"
				+ " set email_usuario = ?, senha = ?"
				+ " where id_usuario = ?";
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, us.getEmail());
			ps.setInt(2, us.getId());
			ps.setString(3, us.getSenha());
	

			if (ps.executeUpdate() > 0) {
				return us;
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
	 * Método para deletar dados na tabela usuario
	 * @Author M&M
	 * @return true or false
	 * */
	
	public static boolean delete(int id) {
		String sql = "delete from usuario where id_usuario = ?";
		
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
	
	