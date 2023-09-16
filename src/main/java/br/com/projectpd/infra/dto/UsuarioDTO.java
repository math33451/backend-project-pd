package br.com.projectpd.infra.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {
	
	private String id;
	private String nomeUsuario;
	private String senha;
	private MembroDTO membro;

}
