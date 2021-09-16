package br.com.alura.forum.controller.dto; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Topico; 

public class TopicoDTO {

     	 private Long id; 
         private String titulo; 
         private String mensagem; 
         private LocalDateTime dataCriacao; 
         
         public TopicoDTO(Topico topico) { 
        	    this.id = topico.getId(); 
        	        this.titulo = topico.getTitulo();
        	        this.mensagem = topico.getMensagem();
        	        this.dataCriacao = topico.getDataCriacao();

        	        }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(LocalDateTime dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		@Override
		public int hashCode() {
			return Objects.hash(dataCriacao, id, mensagem, titulo);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TopicoDTO other = (TopicoDTO) obj;
			return Objects.equals(dataCriacao, other.dataCriacao) && Objects.equals(id, other.id)
					&& Objects.equals(mensagem, other.mensagem) && Objects.equals(titulo, other.titulo);
		}
		
		public static List<TopicoDTO> converter(List<Topico> topicos) {
		    return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
		    
		}


}
         