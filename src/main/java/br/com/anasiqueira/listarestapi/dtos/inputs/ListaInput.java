package br.com.anasiqueira.listarestapi.dtos.inputs;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaInput {
	
	@NotEmpty(message = "O nome para a lista é obrigatório!")
	@Length(message = "O nome para a lista não pode ultrapassar 100 caracteres!", min = 1, max = 100)
	private String nomeLista;

}
