package br.com.anasiqueira.listarestapi.controllers;

import java.net.URISyntaxException;
import java.util.List;

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
import br.com.anasiqueira.listarestapi.entities.ListaEntity;
import br.com.anasiqueira.listarestapi.services.ItemService;
import br.com.anasiqueira.listarestapi.services.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/itens")
@CrossOrigin(origins = "*")
@Tag(name = "Item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemConvert itemConvert;
	
	@Autowired
	private ListaService listaService;	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary = "Criar um novo item", description = "Cria novo item em uma lista")
	public ItemOutput postaItem(@Valid @RequestBody ItemInput itemInput) throws URISyntaxException {
		ItemEntity itemEntity = itemConvert.inputToEntity(itemInput);
		converteIdListaParaListas(itemInput, itemEntity);
		ItemEntity itemPostado = itemService.posta(itemEntity, itemInput);
	return itemConvert.entityToOutput(itemPostado);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Alterar item", description = "Altera um item com novos dados")
	public ItemOutput alterarItem(@PathVariable Long id, @Valid @RequestBody ItemInput itemInput) {
		ItemEntity itemEntity = itemService.chamaPeloId(id);
		itemConvert.copyDataInputToEntity(itemInput, itemEntity);
		ItemEntity itemAlterado = itemService.alterar(itemEntity, itemInput);
	return itemConvert.entityToOutput(itemAlterado);
	}
	
	@GetMapping("/{listaId}/itens")
	@Operation(summary = "Lista itens de uma lista", description = "Lista todos os itens de uma lista")
	public List<ItemOutput> listarItens(@PathVariable Long listaId) {
		List<ItemEntity> listarTodosItens = itemService.chamaItensPeloId(listaId);
	return itemConvert.entityToOutput(listarTodosItens);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Operation(summary = "Remove Item pelo Id", description = "Remove Itens pelo seu Id")
	public void deletaItem(@PathVariable Long id) {
		ItemEntity itemEntity = itemService.chamaPeloId(id);
		itemService.deletar(id);
	}
	
	private void converteIdListaParaListas(ItemInput itemInput, ItemEntity itemEntity) {
		
	}
	
	

}
