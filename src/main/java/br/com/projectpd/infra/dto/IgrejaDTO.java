package br.com.projectpd.infra.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IgrejaDTO {
	
	private String id;
	private MembroDTO responsavel;
	private Long cep;
	private String endereco;
	private String numeroEndereco;
	private String telefone;

}
