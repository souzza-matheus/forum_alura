package br.com.alura.forum.controller.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;
import lombok.Getter;

@Getter
public class DetalhesDoTopicoDTO {

	
	 private Long id; 
     private String titulo; 
     private String mensagem; 
     private LocalDateTime dataCriacao; 
     private String nomeAutor;
     private StatusTopico status;
     private List<RespostaDTO> resposta;
     
     public DetalhesDoTopicoDTO(Topico topico) {
 		
			this.id = topico.getId();
			this.mensagem = topico.getMensagem();
			this.dataCriacao=topico.getDataCriacao();
			this.nomeAutor=topico.getAutor().getNome();
			this.nomeAutor = topico.getAutor().getNome();
			this.status=topico.getStatus();
			this.resposta=new ArrayList<>();
			this.resposta.addAll(topico.getRespostas().stream().map(RespostaDTO::new).collect(Collectors.toList()));
			
			
		}

}
