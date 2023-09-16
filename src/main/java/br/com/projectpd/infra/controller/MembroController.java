package br.com.projectpd.infra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectpd.infra.dto.MembroDTO;
import br.com.projectpd.infra.dto.MembroSaveDTO;
import br.com.projectpd.infra.service.MembroService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/membro")
public class MembroController {
	
	@Autowired
	private MembroService service;
	
	@GetMapping()
	public List<MembroDTO> buscarTodosMembros(){
		return service.findAll();
	}
	
	@GetMapping("/{cpf}")
	public MembroDTO buscarPorCpf(@PathVariable String cpf){
		return service.findByCpf(cpf);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> salvarMembro(@RequestBody MembroSaveDTO membro){
		service.save(membro);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{cpf}")
	public ResponseEntity<?> excluirMembro(@PathVariable String cpf){
		service.excluiMembro(cpf);
		return ResponseEntity.ok().build();
	}
	
}
