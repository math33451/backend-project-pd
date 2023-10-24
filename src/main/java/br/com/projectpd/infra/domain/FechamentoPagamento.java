package br.com.projectpd.infra.domain;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.projectpd.infra.enums.MesFechamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("fechamentoPagamento")
public class FechamentoPagamento {
	
	private List<Pagamento> pagamentos;
	private BigDecimal valorTotal;
	private MesFechamentoEnum mesReferencia;

}
