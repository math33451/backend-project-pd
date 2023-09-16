package br.com.projectpd.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Endereco {
	
	private String cep;
	private String endereco;
	private Long numeroEndereco;
	private String complemento;

}
