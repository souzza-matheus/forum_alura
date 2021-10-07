package br.com.alura.forum.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TokenDTO {
	
	private String token;
	private String tipo;
}
