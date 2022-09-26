package br.com.anasiqueira.listarestapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anasiqueira.listarestapi.entities.ListaEntity;
import br.com.anasiqueira.listarestapi.exceptions.NotFoundBussinessException;
import br.com.anasiqueira.listarestapi.repositories.ListaRepository;

@Service
public class ListaService {

   @Autowired
   private ListaRepository listaRepository;
		
	public ListaEntity posta(ListaEntity listaEntity) {
	return listaRepository.save(listaEntity);
	}
	
	public ListaEntity alterar(ListaEntity listaEntity) {
	return listaRepository.save(listaEntity);
	}
	
	public List<ListaEntity> listarListas() {
	return listaRepository.findAll();
	}
	
	public ListaEntity chamaPeloId(Long id) {
	return listaRepository.findById(id).orElseThrow(() -> new NotFoundBussinessException("Não foi encontrada a lista de id: " + id));
	}
	
	public void deletar(ListaEntity listaEntity) {
		listaRepository.delete(listaEntity);		
	}
	}
