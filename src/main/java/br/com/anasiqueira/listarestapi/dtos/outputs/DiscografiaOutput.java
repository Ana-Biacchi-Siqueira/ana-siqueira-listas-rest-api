package br.com.anasiqueira.listarestapi.dtos.outputs;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscografiaOutput {

	private Long id;
	private String musica;	
	private Integer dataLancamento;
	private String albumDaMusica;
	private List<DiscografiaArtistaOutput> artistas;
}
