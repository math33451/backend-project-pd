package br.com.projectpd.infra.repository.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import br.com.projectpd.infra.domain.Pagamento;
import br.com.projectpd.infra.repository.PagamentoRepositoryCustom;

public class PagamentoRepositoryImpl implements PagamentoRepositoryCustom{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<Pagamento> findByRangeData(LocalDateTime dataInicio, LocalDateTime dataFim) {
		Criteria where = Criteria.where("dataPagamento").gte(dataInicio).lte(dataFim);
		
		List<Pagamento> teste = mongoTemplate.find(Query.query(where), Pagamento.class);
		return teste;
	}
	
	
}
