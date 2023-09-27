package br.com.projectpd.infra.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projectpd.infra.domain.Membro;

public interface MembroRepository extends MongoRepository<Membro, String>{

	Optional<Membro> findByCpf(String cpf);

}
