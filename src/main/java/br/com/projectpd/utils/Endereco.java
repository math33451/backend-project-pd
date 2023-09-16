package br.com.projectpd.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Endereco {
	
	private String cep;
	private String logradouro;
	private Long numeroEndereco;
	private String complemento;
	private String municipio;
	private String uf;
	private String bairro;

}
