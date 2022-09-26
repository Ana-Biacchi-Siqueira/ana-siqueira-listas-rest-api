package br.com.anasiqueira.listarestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anasiqueira.listarestapi.dtos.inputs.ItemInput;
import br.com.anasiqueira.listarestapi.entities.ItemEntity;
import br.com.anasiqueira.listarestapi.exceptions.NotFoundBussinessException;
import br.com.anasiqueira.listarestapi.repositories.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public ItemEntity posta(ItemEntity itemEntity, ItemInput itemInput) {
	return itemRepository.save(itemEntity);
	}
	
	public ItemEntity alterar(ItemEntity itemEntity, ItemInput itemInput) {
	return itemRepository.save(itemEntity);
		}
	
	public ItemEntity chamaPeloId(Long id) {
		return itemRepository.findById(id).orElseThrow(() -> new NotFoundBussinessException("Não foi encontrado o item pelo id: " + id));
		}
	
	public void deletar(Long id) {
		itemRepository.delete(this.chamaPeloId(id));
	}
	
	public List<ItemEntity> chamaItensPeloId(Long listaId) {
	return itemRepository.findAllByListaId(listaId);
		}	
	}
