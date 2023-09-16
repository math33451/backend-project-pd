package br.com.projectpd.infra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectpd.client.ServicoDeCep;
import br.com.projectpd.utils.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private ServicoDeCep servicoDeCep;

	public Endereco buscaPorCep(String cep) throws Exception {
		return servicoDeCep.buscaEnderecoPelo(cep);
	}

}
