package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.Avaliacao;

public class AvaliacaoRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações da avaliacao
	 * @Author M&M
	 * @return null or avaliacoes
	 * */
	
	public static ArrayList<Avaliacao> findAll() {
		ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		String sql = "select * from avaliacao";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Avaliacao av = new Avaliacao();
					av.setId(rs.getInt("id_avaliacao"));
					av.setNota(rs.getInt("nota_avaliacao"));
					av.setDescricao(rs.getString("descricao_avaliacao"));
					
					avaliacoes.add(av);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar avaliacao: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return avaliacoes;
		
	}
	
	/**
	 * Método para inserir dados na tabela avaliacao
	 * @Author M&M
	 * @return null or avaliacoes
	 * */
	
	public static Avaliacao save(Avaliacao av) {
		String sql = "insert into avaliacao"
				+ "(nota_avaliacao, descricao_avaliacao)"
				+ " values(?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setInt(1, av.getNota());
			ps.setString(2, av.getDescricao());

			
			
			if (ps.executeUpdate() > 0) {
				return av;
				
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