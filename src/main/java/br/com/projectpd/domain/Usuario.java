package br.com.projectpd.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("usuario")
public class Usuario {
	
	@Id
	private String id;
	private String nomeUsuario;
	private String senha;
	private Membro membro;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

}
