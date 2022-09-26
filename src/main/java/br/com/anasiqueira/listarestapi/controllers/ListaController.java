package br.com.anasiqueira.listarestapi.controllers;

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
import br.com.anasiqueira.listarestapi.converts.ListaConvert;
import br.com.anasiqueira.listarestapi.dtos.inputs.ListaInput;
import br.com.anasiqueira.listarestapi.dtos.outputs.ListaOutput;
import br.com.anasiqueira.listarestapi.entities.ListaEntity;
import br.com.anasiqueira.listarestapi.services.ItemService;
import br.com.anasiqueira.listarestapi.services.ListaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/listas")
@CrossOrigin(origins = "*") 
@Tag(name = "Lista")
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
	@Operation(summary = "Criar uma lista", description = "Cria uma nova lista.")
	public ListaOutput postaLista(@Valid @RequestBody ListaInput lista) {
		ListaEntity listaEntity = listaConvert.inputToEntity(lista);
		ListaEntity listaPostada = listaService.posta(listaEntity);
	return listaConvert.entityToOutput(listaPostada);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Altera uma lista", description = "Altera uma lista com novos dados")
	public ListaOutput alterarLista(@PathVariable Long id, @Valid @RequestBody ListaInput listaInput) {
		ListaEntity listaEntity = listaConvert.inputToEntity(listaInput);
		listaEntity.setId(id);
		ListaEntity listaAlterada = listaService.alterar(listaEntity);
	return listaConvert.entityToOutput(listaAlterada);
	}
	
	@GetMapping
	@Operation(summary = "Listar todas lista", description = "Fará listar todas as listas cadastradas")
	public List<ListaOutput> listarListas() {
		List<ListaEntity> listarTodas = listaService.listarListas();
	return listaConvert.entityToOutput(listarTodas);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Buscar lista pelo Id", description = "Busca uma lista pelo seu Id.")
	public ListaOutput chamaListasPorId(@PathVariable Long id) {
		ListaEntity listaEntity = listaService.chamaPeloId(id);
	return listaConvert.entityToOutput(listaEntity);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deleta uma lista pelo seu Id", description = "Deleta uma lista pelo seu Id")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletaLista(@PathVariable Long id) {
		ListaEntity listaEntity = listaService.chamaPeloId(id);
		listaService.deletar(listaEntity);
	}
}
