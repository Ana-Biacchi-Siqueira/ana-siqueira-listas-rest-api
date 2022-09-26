package br.com.anasiqueira.listarestapi.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.anasiqueira.listarestapi.dtos.inputs.ListaInput;
import br.com.anasiqueira.listarestapi.dtos.outputs.ListaOutput;
import br.com.anasiqueira.listarestapi.entities.ListaEntity;

@Component
public class ListaConvert {
	
	@Autowired
	private ModelMapper model;
	
	public ListaOutput entityToOutput(ListaEntity listaEntity) {
		return model.map(listaEntity, ListaOutput.class);
	}
	public ListaEntity inputToEntity(ListaInput listaInput) {
		return model.map(listaInput, ListaEntity.class);
	}
	public List<ListaOutput> entityToOutput(List<ListaEntity> listarTodos) {
		return listarTodos.stream().map(lista -> this.entityToOutput(lista)).collect(Collectors.toList());
	}
	public void copyDataInputToEntity(ListaInput listaInput, ListaEntity listaEntity) {
		model.map(listaInput, listaEntity);
	}
	
}
