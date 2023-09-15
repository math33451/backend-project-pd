package br.com.projectpd.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Endereco {
	
	private Long cep;
	private String endereco;
	private Long numeroEndereco;
	private String complemento;

}
