package br.com.projectpd.infra.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MembroSaveDTO {

	private String id;
	private String cpf;
	private String nomeCompleto;
	private String titulo;
	private LocalDate dataNascimento;
	private Long numeroTelefone;
	private String email;
	private String cep;
	private String endereco;
	private Long numeroEndereco;
	private String complemento;
}
