package br.com.cotiinformatica.repositories;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class ContaRepository {

	private JdbcTemplate jdbcTemplate;

	public ContaRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
