package br.com.projectpd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projectpd.domain.Membro;
import br.com.projectpd.repository.MembroRepository;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/membro")
public class MembroController {
	
	@Autowired
	private MembroRepository repository;
	
	@GetMapping()
	public List<Membro> buscarTodosMembros(){
		return repository.findAll();
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> salvarMembro(@RequestBody Membro membro){
		repository.save(membro);
		return ResponseEntity.ok().build();
	}
	
}
