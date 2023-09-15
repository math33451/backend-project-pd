package br.com.projectpd.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projectpd.utils.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("membro")
public class Membro {
	
	@Id
	private String id;
	private String cpf;
	private String nomeCompleto;
	private LocalDate dataNascimento;
	private Endereco endereco;
	
}
