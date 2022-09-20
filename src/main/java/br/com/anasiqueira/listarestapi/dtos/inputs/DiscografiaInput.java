package br.com.anasiqueira.listarestapi.dtos.inputs;

import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscografiaInput {
	
	@Length(max = 100)
	@NotBlank(message = "O nome da musica é obrigatório")
	private String musica;
	
	@DecimalMax("9999")
	private Integer dataLancamento;
	
	@NotBlank(message = "Musica deve ser cadastrada com o nome de um álbum")
	private String albumDaMusica;
	
	@NotEmpty(message = "Deve haver ao menos um cantor.")
	private List<Long> idsArtistas;
	

}
