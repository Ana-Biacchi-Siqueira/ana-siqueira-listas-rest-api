package br.com.anasiqueira.listarestapi.dtos.inputs;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistaInput {
		
		@Length(max = 100)
		@NotBlank(message = "Nome do Artista é obrigatório.")
		private String nome;	
}
