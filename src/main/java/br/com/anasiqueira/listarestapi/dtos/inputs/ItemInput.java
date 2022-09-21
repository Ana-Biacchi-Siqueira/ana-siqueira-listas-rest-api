package br.com.anasiqueira.listarestapi.dtos.inputs;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemInput {
	
	@NotEmpty(message = "O nome para o item é obrigatório!")
	@Length(message = "O nome para o item não pode ultrapassar 100 caracteres!", min = 1, max = 100)
	private String nomeItem;

}
