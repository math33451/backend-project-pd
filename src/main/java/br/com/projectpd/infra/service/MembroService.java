package br.com.projectpd.infra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectpd.infra.domain.Membro;
import br.com.projectpd.infra.dto.MembroDTO;
import br.com.projectpd.infra.dto.MembroSaveDTO;
import br.com.projectpd.infra.repository.MembroRepository;
import br.com.projectpd.utils.Endereco;


@Service
public class MembroService {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private MembroRepository repository;
	

	public List<MembroDTO> findAll() {
		List<Membro> membros = repository.findAll();
		List<MembroDTO> listaDTO = membros.stream().map(m -> modelMapper.map(m, MembroDTO.class)).collect(Collectors.toList());
		return listaDTO;
	}
	
	public MembroDTO findByCpf(String cpf) {
		Membro domain = findDomainPorCpf(cpf);
		MembroDTO dto = modelMapper.map(domain, MembroDTO.class);
		return dto;
	}

	public void save(MembroSaveDTO dto) {
		Endereco novoEndereco = modelMapper.map(dto, Endereco.class);
		Membro domain = modelMapper.map(dto, Membro.class);
		domain.setEndereco(novoEndereco);
		repository.save(domain);
		
	}

	public void excluiMembro(String cpf) {
		Membro domain = findDomainPorCpf(cpf);
		repository.delete(domain);
	}
	
	protected Membro findDomainPorCpf(String cpf) {
		Membro domain = repository.findByCpf(cpf);
		return domain;
	}

}
