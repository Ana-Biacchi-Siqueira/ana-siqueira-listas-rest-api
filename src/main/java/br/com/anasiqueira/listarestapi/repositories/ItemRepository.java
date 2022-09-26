package br.com.anasiqueira.listarestapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anasiqueira.listarestapi.entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
	
		List<ItemEntity> findAllByListaId(Long listaId);
		
	}
