package br.com.projectpd.infra.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PagamentoDTO {

	private String id;
	private BigDecimal valor;
	private MembroDTO pagante;
	private String cpfPagante;
	private LocalDate dataPagamento;

}
