package br.com.projectpd.infra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projectpd.infra.domain.Pagamento;

public interface PagamentoRepository extends MongoRepository<Pagamento, String>,PagamentoRepositoryCustom{

}
