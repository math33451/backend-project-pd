package br.com.projectpd.infra.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
