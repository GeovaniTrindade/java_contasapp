package br.com.cotiinformatica.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.cotiinformatica.entities.Usuario;

public class UsuarioRepository {
	// atributo
	private JdbcTemplate jdbcTemplate;

	// método construtor para recebermos a conexão
	// com o banco de dados
	// ou seja, recebermos o DATA SOURCE configurado na classe
	// MvcConfiguration.java
	public UsuarioRepository(DataSource dataSource) {
		// inicialiando o atributo jdbcTemplate passando para ele
		// o DATA SOURCE (conexão com o banco de dados)
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// método para inserir um usuário no banco de dados
	public void create(Usuario usuario) throws Exception {

		// escrevendo a instrução SQL que
		// será executada no banco de dados
		String sql = "insert into usuario(nome, email, senha) values(?,?,?)";

		// definindo quais dados/parâmetros
		// serão gravados na tabela
		Object[] params = { usuario.getNome(), usuario.getEmail(), usuario.getSenha() };

		// executando no banco de dados
		jdbcTemplate.update(sql, params);
	}

	// método para consultar 1 usuário através do email
	public Usuario find(String email) throws Exception {

		// escrevendo a instrução SQL que será
		// executada no banco de dados
		String sql = "select * from usuario where email = ?";

		// definindo quais dados/parâmetros serão passados na query
		Object[] params = { email };

		// executando a consulta e obtendo os dados da tabela
		List<Usuario> resultado = jdbcTemplate.query(sql, params, new RowMapper<Usuario>() {

			// método para ler cada registro
			// obtido da consulta no banco de dados
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

				Usuario usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));

				return usuario;
			}
		});

		// verificando se algum usuário foi encontrado
		if (resultado.size() > 0)
			return resultado.get(0);
		// retornar o primeiro usuário contido na lista
		else
			return null; // retornar vazio
	}

	// método para consultar 1 usuário através do email e da senha
	public Usuario find(String email, String senha) throws Exception {

		// escrevendo a instrução SQL que será
		// executada no banco de dados
		String sql = "select * from usuario where email = ? and senha = ?";

		// definindo quais dados/parâmetros serão passados na query
		Object[] params = { email, senha };

		// executando a consulta e obtendo os dados da tabela
		List<Usuario> resultado = jdbcTemplate.query(sql, params, new RowMapper<Usuario>() {

			// método para ler cada registro
			// obtido da consulta no banco de dados
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {

				Usuario usuario = new Usuario();

				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));

				return usuario;
			}
		});

		// verificando se algum usuário foi encontrado
		if (resultado.size() > 0)
			return resultado.get(0);
		// retornar o primeiro usuário contido na lista
		else
			return null; // retornar vazio
	}
}
