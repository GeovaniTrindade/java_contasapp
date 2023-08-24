package br.com.cotiinformatica.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Conta {

	private Integer id;
	private String nome;
	private String descricao;
	private Date data;
	private Double valor;
	private Integer tipo;
	private Usuario usuario;

}
