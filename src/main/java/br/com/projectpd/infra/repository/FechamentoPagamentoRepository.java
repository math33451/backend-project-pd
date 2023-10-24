package br.com.projectpd.infra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projectpd.infra.domain.FechamentoPagamento;

public interface FechamentoPagamentoRepository extends MongoRepository<FechamentoPagamento, String>{

}
