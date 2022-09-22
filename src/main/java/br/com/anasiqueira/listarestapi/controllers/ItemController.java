package br.com.anasiqueira.listarestapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.anasiqueira.listarestapi.converts.ItemConvert;
import br.com.anasiqueira.listarestapi.dtos.inputs.ItemInput;
import br.com.anasiqueira.listarestapi.dtos.outputs.ItemOutput;
import br.com.anasiqueira.listarestapi.entities.ItemEntity;
import br.com.anasiqueira.listarestapi.services.ItemService;
import br.com.anasiqueira.listarestapi.services.ListaService;

@RestController
@RequestMapping("/api/itens")
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ListaService listaService;
	
	@Autowired
	private ItemConvert itemConvert;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ItemOutput postaItem(@Valid @RequestBody ItemInput item) {
		ItemEntity itemEntity = itemConvert.inputToEntity(item);
		convertListas(item, itemEntity);
		ItemEntity itemPostado = itemService.posta(itemEntity);
	return itemConvert.entityToOutput(itemPostado);
	}
	
	@PutMapping("/{id}")
	public ItemOutput alterarItem(@PathVariable Long id, @Valid @RequestBody ItemInput itemInput) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemConvert.copyDataInputToEntity(itemInput, itemEntity);
		ItemEntity itemAlterado = itemService.alterar(itemEntity);
	return itemConvert.entityToOutput(itemAlterado);
	}
	
	@GetMapping("/{id}")
	public ItemOutput buscaItemPorId(@PathVariable Long id) {
		ItemEntity  itemEntity = itemService.buscaPorId(id);
	return itemConvert.entityToOutput(itemEntity);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaItem(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.buscaPeloId(id);
		itemService.deletar(itemEntity);
	}
	
	

}
