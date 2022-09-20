package br.com.anasiqueira.listarestapi.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscografiaArtistaOutput {
	
	private Long id;
	private String musica;
	private Integer dataLancamento; 
	private String albumDaMusica;
	
	
}
