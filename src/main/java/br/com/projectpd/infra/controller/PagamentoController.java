package br.com.projectpd.infra.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectpd.infra.domain.FechamentoPagamento;
import br.com.projectpd.infra.dto.PagamentoDTO;
import br.com.projectpd.infra.dto.PagamentoSaveDTO;
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
	
	@GetMapping("/{id}")
	public PagamentoDTO buscarPorId(@PathVariable String id) throws Exception{
		return service.findById(id);
	}
	
	@GetMapping("/documento/{cpf}")
	public PagamentoDTO buscarPorMembro(@PathVariable String cpf){
		return null;
	}
	
	@GetMapping("/data/{data}")
	public PagamentoDTO buscarPorData(@PathVariable LocalDate data){
		return null;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> salvarPagamento(@RequestBody PagamentoSaveDTO dto) throws Exception{
		service.save(dto);
		return ResponseEntity.ok("Pagamento registrado com sucesso.");
	}
	
	@GetMapping("/fecharMes/{mes}")
	public FechamentoPagamento fecharMes(@PathVariable Integer mes) {
		return service.fecharMes(mes);
	}

}
