package br.com.projectpd.infra.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Document("pagamento")
public class Pagamento {

	@Id
	private String id;
	private BigDecimal valor;
	private Membro pagante;
	private LocalDate dataPagamento;

}
