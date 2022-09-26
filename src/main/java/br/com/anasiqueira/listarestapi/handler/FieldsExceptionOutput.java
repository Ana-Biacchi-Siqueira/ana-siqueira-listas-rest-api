package br.com.anasiqueira.listarestapi.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldsExceptionOutput {
	
	private String name;
	private String message;
	
}
