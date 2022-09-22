package br.com.anasiqueira.listarestapi.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.anasiqueira.listarestapi.dtos.inputs.ItemInput;
import br.com.anasiqueira.listarestapi.dtos.outputs.ItemOutput;
import br.com.anasiqueira.listarestapi.entities.ItemEntity;

@Component
public class ItemConvert {
	
	@Autowired
	private ModelMapper model;
	
	public ItemOutput entityToOutput(ItemEntity itemEntity) {
		return model.map(itemEntity, ItemOutput.class);
	}
	public ItemEntity inputToEntity(ItemInput itemInput) {
		return model.map(itemInput, ItemEntity.class);
	}
	public List<ItemOutput> entityToOutput(List<ItemEntity> itensEntity) {
		return itensEntity.stream().map(item -> this.entityToOutput(item)).collect(Collectors.toList());
	}
	public void copyDataInputToEntity(ItemInput itemInput, ItemEntity itemEntity) {
		model.map(itemInput, itemEntity);
	}
	
}