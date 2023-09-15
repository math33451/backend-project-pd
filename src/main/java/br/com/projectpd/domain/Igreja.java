package br.com.projectpd.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("igreja")
public class Igreja {
	
	@Id
	private String id;
	private Membro responsavel;
	private Long cep;
	private String endereco;
	private String numeroEndereco;
	private String telefone;

}
