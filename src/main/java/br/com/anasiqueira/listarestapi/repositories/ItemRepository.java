package br.com.anasiqueira.listarestapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anasiqueira.listarestapi.entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
	
		Optional<ItemEntity> findsById(Long id);
		
	}
