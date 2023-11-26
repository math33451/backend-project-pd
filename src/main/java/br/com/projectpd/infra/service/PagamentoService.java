package br.com.projectpd.infra.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projectpd.infra.domain.FechamentoPagamento;
import br.com.projectpd.infra.domain.Membro;
import br.com.projectpd.infra.domain.Pagamento;
import br.com.projectpd.infra.dto.MembroDTO;
import br.com.projectpd.infra.dto.PagamentoDTO;
import br.com.projectpd.infra.dto.PagamentoSaveDTO;
import br.com.projectpd.infra.enums.MesFechamentoEnum;
import br.com.projectpd.infra.repository.PagamentoRepository;


@Service
public class PagamentoService {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	private PagamentoRepository repository;
	
	@Autowired
	private MembroService membroService;
	
	@Autowired
	private CriarArquivoExcelService criarArquivoExcelService;

	public List<PagamentoDTO> findAll() {
		List<Pagamento> pagamentos = repository.findAll();
		List<PagamentoDTO> listaDTO = pagamentos.stream().map(m -> modelMapper.map(m, PagamentoDTO.class)).collect(Collectors.toList());
		Collections.sort(listaDTO, new Comparator<PagamentoDTO>() {
			  public int compare(PagamentoDTO o1, PagamentoDTO o2) {
			      if (o1.getDataPagamento() == null || o2.getDataPagamento() == null)
			        return 0;
			      return o2.getDataPagamento().compareTo(o1.getDataPagamento());
			  }
			});
		
		listaDTO.forEach(i ->{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			i.setDataExibicao(i.getDataPagamento().format(formatter));
			return;
			});
		
		
		return listaDTO;
	}
	
//	public PagamentoDTO findByMembro(String cpf) {
//		Membro membro = membroService.findDomainPorCpf(cpf);
//		Pagamento domain = repository.findByMembro(membro);
//		PagamentoDTO dto = modelMapper.map(domain, PagamentoDTO.class);
//		return dto;
//	}

	public void save(PagamentoSaveDTO dto) throws Exception {
		Pagamento novoPagamento = new Pagamento();
		Membro membro = membroService.findDomainPorCpf(dto.getCpfPagante());
		if(membro == null) {
			throw new Exception("Erro ao processar pagamento, tente novamente mais tarde.");
		}
		novoPagamento.setPagante(membro);
		novoPagamento.setValor(dto.getValor());
		novoPagamento.setDataPagamento(LocalDateTime.now());
		repository.save(novoPagamento);
	}

	public PagamentoDTO findById(String id) throws Exception {
		Optional<Pagamento> domain = repository.findById(id);
		if(domain.isEmpty()) {
			throw new Exception("Pagamento não encontrado.");
		}
		MembroDTO membroDTO = modelMapper.map(domain.get().getPagante(), MembroDTO.class);		
		PagamentoDTO dto = mapearDTO(domain.get(), membroDTO);
		return dto;
	}

	private PagamentoDTO mapearDTO(Pagamento domain, MembroDTO membroDTO) {
		PagamentoDTO dto = new PagamentoDTO();
		dto.setId(domain.getId());
		dto.setValor(domain.getValor());
		dto.setDataPagamento(domain.getDataPagamento());
		dto.setCpfPagante(domain.getPagante().getCpf());
		dto.setPagante(membroDTO);
		
		return dto;
	}

	public byte[] fecharMes(Integer mes) {
		BigDecimal valorTotal = BigDecimal.ZERO;
		List<Pagamento> pagamentos = findByRangeData(mes);
		for(Pagamento p : pagamentos) {
			valorTotal = valorTotal.add(p.getValor());
		}
		
		FechamentoPagamento fechamento = new FechamentoPagamento(pagamentos, valorTotal, MesFechamentoEnum.findById(mes));
		return criarArquivoExcelService.criarArquivo("testeArquivoExcel", fechamento);
	}
	
	private List<Pagamento> findByRangeData(Integer mes){
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime dataInicio = LocalDateTime.of(hoje.getYear(), mes, 1, 0, 0);
		LocalDateTime dataFim = LocalDateTime.of(hoje.getYear(), mes, 29, 23, 59);
		return repository.findByRangeData(dataInicio, dataFim);
	}

}
