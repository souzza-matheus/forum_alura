package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.DetalhesDoTopicoDTO;
import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	@GetMapping("/topicos")
	public List<TopicoDTO>lista(String nomeDoCurso){
		if(nomeDoCurso == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDTO.converter(topicos);
		}else {
			List<Topico>topicos=topicoRepository.findByCursoNome(nomeDoCurso);
			return TopicoDTO.converter(topicos);
		}
		
		
	}
	
	@PostMapping("/topicos")
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
		
	}
	
	@GetMapping("/topicos/{id}")
	public DetalhesDoTopicoDTO detalhar(@PathVariable Long id){
		Topico topico = topicoRepository.getOne(id);
		return new DetalhesDoTopicoDTO(topico);
		
	}
	
	
	@PutMapping("/topicos/{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> atualizarTopico(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form){
		Topico topico = form.atualizar(id, topicoRepository);
		return ResponseEntity.ok(new TopicoDTO(topico));
	}
	@DeleteMapping("/topicos/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id){
		
		topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
	

}
