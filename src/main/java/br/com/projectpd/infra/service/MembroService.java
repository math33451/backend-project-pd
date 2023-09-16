package br.com.projectpd.infra.service;

import java.util.List;
import java.util.Optional;
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

	public void save(MembroSaveDTO dto) throws Exception {
		Membro membroExistente = findDomainPorCpf(dto.getCpf());
		if(membroExistente != null) {
			throw new Exception("Já existe um membro com este CPF.");
		}
		Endereco novoEndereco = modelMapper.map(dto, Endereco.class);
		Membro domain = modelMapper.map(dto, Membro.class);
		domain.setEndereco(novoEndereco);
		repository.save(domain);
		
	}
	
	public void editarMembro(MembroSaveDTO dto) {
		Membro domain = repository.findById(dto.getId()).get();
		Membro novoRegistro = modelMapper.map(dto, Membro.class);
		Endereco novoEndereco = modelMapper.map(dto, Endereco.class);
		novoRegistro.setId(domain.getId());
		novoRegistro.setEndereco(novoEndereco);
		repository.delete(domain);
		repository.save(novoRegistro);
		}

	public void excluiMembro(String cpf) {
		Membro domain = findDomainPorCpf(cpf);
		repository.delete(domain);
	}
	
	protected Membro findDomainPorCpf(String cpf) {
		Optional<Membro> domain = repository.findByCpf(cpf);
		if(domain.isEmpty()) {
			return null;
		}
		return domain.get();
	}

	public MembroDTO findById(String id) throws Exception {
		Optional<Membro> domain = repository.findById(id);
		if(domain.isEmpty()) {
			throw new Exception("Não foi encontrado membro com este id.");
		}
		MembroDTO dto = modelMapper.map(domain.get(), MembroDTO.class);
		return dto;
	}

}
