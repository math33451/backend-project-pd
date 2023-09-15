package br.com.projectpd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.projectpd.domain.Membro;

public interface MembroRepository extends MongoRepository<Membro, String>{

}
