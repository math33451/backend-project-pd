package br.com.projectpd.infra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectpd.infra.service.EnderecoService;
import br.com.projectpd.utils.Endereco;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService service;
	
	@GetMapping("/{cep}")
	private Endereco buscaPorCep(@PathVariable String cep) throws Exception {
		return service.buscaPorCep(cep);
	}

}
