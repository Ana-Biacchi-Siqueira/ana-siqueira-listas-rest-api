package br.com.anasiqueira.listarestapi.configs.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	public OpenAPI springShopOpenAPI() {
		OpenAPI openApi = new OpenAPI();

		Info info = new Info();
		info.title("Terceira avaliação - Listas Rest API");
		info.version("v0.0.1");
		info.description("<div>"
				+ "       	<h2>Descrição:<h2>"
				+ "			<h3>Documentação do Swagger da Rest API, com Listas e itens das listas</h3>"
				+ "		  </div>"
				 );

		openApi.info(info);
		openApi.addTagsItem(new Tag().name("Lista").description("Controller de Listas"));
		openApi.addTagsItem(new Tag().name("Item").description("Controller de Itens"));
	return openApi;
	}

}
