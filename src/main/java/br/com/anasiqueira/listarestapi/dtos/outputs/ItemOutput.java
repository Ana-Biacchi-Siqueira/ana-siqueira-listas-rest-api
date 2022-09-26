package br.com.anasiqueira.listarestapi.dtos.outputs;

import br.com.anasiqueira.listarestapi.entities.ListaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemOutput {

	private Long id;
	private String nomeItem;
	private ListaEntity listas;
	
}
