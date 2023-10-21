package br.com.projectpd.infra.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FechamentoPagamento {
	
	private List<Pagamento> pagamentos;
	private BigDecimal valorTotal;

}
