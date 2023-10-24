package br.com.projectpd.infra.repository;

import java.time.LocalDateTime;
import java.util.List;

import br.com.projectpd.infra.domain.Pagamento;

public interface PagamentoRepositoryCustom {

	List<Pagamento> findByRangeData(LocalDateTime dataInicio, LocalDateTime dataFim);
}
