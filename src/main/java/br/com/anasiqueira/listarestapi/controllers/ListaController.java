package br.com.anasiqueira.listarestapi.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.anasiqueira.listarestapi.converts.ItemConvert;
import br.com.anasiqueira.listarestapi.converts.ListaConvert;
import br.com.anasiqueira.listarestapi.dtos.inputs.ListaInput;
import br.com.anasiqueira.listarestapi.dtos.outputs.ListaOutput;
import br.com.anasiqueira.listarestapi.entities.ListaEntity;
import br.com.anasiqueira.listarestapi.services.ItemService;
import br.com.anasiqueira.listarestapi.services.ListaService;

@RestController
@RequestMapping("/api/listas")
@CrossOrigin(origins = "*") 
public class ListaController {
	
	@Autowired
	private ListaService listaService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ListaConvert listaConvert;
	
	@Autowired
	private ItemConvert itemConvert;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ListaOutput postaLista(@Valid @RequestBody ListaInput lista) {
		ListaEntity listaEntity = listaConvert.inputToEnity(lista);
		ListaEntity listaPostada = listaService.posta(listaEntity);
	return listaConvert.entityToOutput(listaPostada);
	}
	
	@PutMapping("/{id}")
	public ListaOutput alterarLista(@PathVariable Long id, @Valid @RequqestBody ListaInput listaInput) {
		ListaEntity listaEntity = listaConvert.inputToEntity(listaInput);
		listaEntity.setId(id);
		ListaEntity listaAlterada = listaService.altera(listaEntity);
	return listaConvert.entityToOutput(listaAlterada);
	}
	
	
}
