package br.com.projectpd.infra.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectpd.infra.domain.Membro;
import br.com.projectpd.infra.domain.Pagamento;
import br.com.projectpd.infra.dto.PagamentoDTO;
import br.com.projectpd.infra.repository.PagamentoRepository;


@Service
public class PagamentoService {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private PagamentoRepository repository;
	
	@Autowired
	private MembroService membroService;

	public List<PagamentoDTO> findAll() {
		List<Pagamento> membros = repository.findAll();
		List<PagamentoDTO> listaDTO = membros.stream().map(m -> modelMapper.map(m, PagamentoDTO.class)).collect(Collectors.toList());
		return listaDTO;
	}
	
//	public PagamentoDTO findByMembro(String cpf) {
//		Membro membro = membroService.findDomainPorCpf(cpf);
//		Pagamento domain = repository.findByMembro(membro);
//		PagamentoDTO dto = modelMapper.map(domain, PagamentoDTO.class);
//		return dto;
//	}

	public void save(PagamentoDTO dto) {
		Pagamento novoPagamento = modelMapper.map(dto, Pagamento.class);
		Membro membro = membroService.findDomainPorCpf(dto.getCpfPagante());
		novoPagamento.setPagante(membro);
		novoPagamento.setDataPagamento(LocalDate.now());
		repository.save(novoPagamento);
		
	}

}
