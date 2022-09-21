package br.com.anasiqueira.listarestapi.dtos.outputs;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutput {

	private Long id;
	private String nomeItem;
	private List<ListaOutput> listas;
	
}
