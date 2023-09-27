package br.com.projectpd.infra.dto;

import java.time.LocalDate;

import br.com.projectpd.utils.Endereco;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MembroDTO {
	
	private String id;
	private String cpf;
	private String nomeCompleto;
	private String titulo;
	private LocalDate dataNascimento;
	private Long numeroTelefone;
	private String email;
	private Endereco endereco;
	
}
