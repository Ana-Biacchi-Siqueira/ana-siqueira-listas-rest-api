package br.com.anasiqueira.listarestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.anasiqueira.listarestapi.entities.ListaEntity;

@Repository
public interface ListaRepository extends JpaRepository<ListaEntity, Long> {
	
}
