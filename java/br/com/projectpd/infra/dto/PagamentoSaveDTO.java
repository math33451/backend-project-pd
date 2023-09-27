package br.com.projectpd.infra.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PagamentoSaveDTO {

	private BigDecimal valor;
	private String cpfPagante;

}
