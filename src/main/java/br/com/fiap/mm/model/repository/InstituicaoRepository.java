package br.com.fiap.mm.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.fiap.mm.model.entity.Instituicao;


public class InstituicaoRepository extends Repository{
	
	
	/**
	 * Método para retorno de informações do instituicao
	 * @Author M&M
	 * @return null or instituicoes
	 * */
	
	public static ArrayList<Instituicao> findAll() {
		ArrayList<Instituicao> instituicoes = new ArrayList<Instituicao>();
		String sql = "select * from instituicao";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					Instituicao inst = new Instituicao();
					inst.setId(rs.getInt("id_instituicao"));
					inst.setCnpj(rs.getString("cnpj_instituicao"));
					inst.setNome(rs.getString("nome_instituicao"));
					inst.setEndereco(rs.getString("endereco_instituicao"));
					inst.setTipo(rs.getString("tipo_instituicao"));
					
					
					instituicoes.add(inst);
				}
				
				
			} else {
				return null;

			}
			
		} catch (SQLException e) {
			System.out.println("Erro ao listar instituicao: " + e.getMessage());
			
		} finally {
			closeConnection();
		}
		return instituicoes;
		
	}
	
	/**
	 * Método para inserir dados na tabela instituicao
	 * @Author M&M
	 * @return null or instituicoes
	 * */
	
	public static Instituicao save(Instituicao inst) {
		String sql = "insert into instituicao"
				+ "(cnpj_instituicao, nome_instituicao, endereco_instituicao, tipo_instituicao)"
				+ " values(?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = getConnection().prepareStatement(sql);

			ps.setString(1, inst.getCnpj());
			ps.setString(2, inst.getNome());
			ps.setString(3, inst.getEndereco());
			ps.setString(4, inst.getTipo());

			
			
			if (ps.executeUpdate() > 0) {
				return inst;
				
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