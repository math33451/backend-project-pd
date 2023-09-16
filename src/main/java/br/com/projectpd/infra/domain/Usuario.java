package br.com.projectpd.infra.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("usuario")
public class Usuario {
	
	@Id
	private String id;
	private String nomeUsuario;
	private String senha;
	private Membro membro;

}
