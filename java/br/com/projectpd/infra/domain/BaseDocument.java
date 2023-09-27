package br.com.projectpd.infra.domain;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BaseDocument {

	private LocalDate dataAtualizacao;
	private String usuarioAtualizacao;

}
