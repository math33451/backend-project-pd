package br.com.projectpd.infra.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projectpd.utils.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document("membro")
public class Membro {
	
	@Id
	private String id;
	private String cpf;
	private String nomeCompleto;
	private String titulo;
	private LocalDate dataNascimento;
	private Long numeroTelefone;
	private String email;
	private Endereco endereco;
	
}
