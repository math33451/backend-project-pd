package br.com.projectpd.infra.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import br.com.projectpd.infra.domain.FechamentoPagamento;
import br.com.projectpd.infra.domain.Pagamento;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CriarArquivoExcelService {

    public byte[] criarArquivo(final String nomeArquivo, FechamentoPagamento fechamento) {
        log.info("Gerando o arquivo {}", nomeArquivo);

        try (var workbook = new XSSFWorkbook();ByteArrayOutputStream byteArrayOutPutStream = new ByteArrayOutputStream();) {
        	
        	
        	
            Sheet planilha = workbook.createSheet("Lista de Pagamento");
            int numeroDaLinha = 0;

            adicionarCabecalho(planilha, numeroDaLinha++);
            
            List<Pagamento> pagamentos = fechamento.getPagamentos();

            for (Pagamento pagamento : pagamentos) {
                var linha = planilha.createRow(numeroDaLinha++);
                adicionarCelula(linha, 0, pagamento.getPagante().getNomeCompleto());
                adicionarCelula(linha, 1, pagamento.getPagante().getCpf());
                adicionarCelula(linha, 2, "R$" + pagamento.getValor().toString());
                adicionarCelula(linha, 3, formataDataParaExcel(pagamento.getDataPagamento()));
            }
            
            var linha = planilha.createRow(numeroDaLinha+2);
            adicionarCelula(linha, 0, "TOTAL DO MES " + fechamento.getMesReferencia().getDescricao().toUpperCase());
            adicionarCelula(linha, 1, "R$" + fechamento.getValorTotal().toString());

            workbook.write(byteArrayOutPutStream);
            log.info("Arquivo gerado com sucesso!");
            return byteArrayOutPutStream.toByteArray();
        } catch (FileNotFoundException e) {
            log.error("Arquivo não encontrado: {}", nomeArquivo);
        } catch (IOException e) {
            log.error("Erro ao processar o arquivo: {} ", nomeArquivo);
        }
        return null;
    }

    private void adicionarCabecalho(Sheet planilha, int numeroLinha) {
        var linha = planilha.createRow(numeroLinha);
        adicionarCelula(linha, 0, "Nome");
        adicionarCelula(linha, 1, "CPF");
        adicionarCelula(linha, 2, "Valor");
        adicionarCelula(linha, 3, "Data");
    }

    private void adicionarCelula(Row linha, int coluna, String valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }

    private void adicionarCelula(Row linha, int coluna, int valor) {
        Cell cell = linha.createCell(coluna);
        cell.setCellValue(valor);
    }
    
    private String formataDataParaExcel(LocalDateTime data) {
    	String dataFormatada = new String();
    	dataFormatada = data.getDayOfMonth() + "/" + data.getMonthValue() + "/" + data.getYear() + " " 
    			+ data.getHour() + ":" + data.getMinute() + ":" + data.getSecond();
    	
    	return dataFormatada;
    }
}
