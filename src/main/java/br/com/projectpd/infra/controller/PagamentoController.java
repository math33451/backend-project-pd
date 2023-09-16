package br.com.projectpd.infra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectpd.infra.dto.PagamentoDTO;
import br.com.projectpd.infra.service.PagamentoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/pagamento")
public class PagamentoController {
	
	@Autowired
	private PagamentoService service;
	
	@GetMapping()
	public List<PagamentoDTO> buscarTodosPagamentos(){
		return service.findAll();
	}
	
	@GetMapping("/{cpf}")
	public PagamentoDTO buscarPorMembro(@PathVariable String cpf){
		return null;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> salvarPagamento(@RequestBody PagamentoDTO membro){
		service.save(membro);
		return ResponseEntity.ok().build();
	}

}