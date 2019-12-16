package br.com.eicon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfigEicon {

//	http://localhost:8080/swagger-ui.html
	@Bean
	public Docket apiSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				// Disponibilizar todas as apis e caminhos
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaData())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessageGETGlobal());
	}

	private List<ResponseMessage> responseMessageGETGlobal(){
		return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1922547239811229402L;
		{
			add(new ResponseMessageBuilder()
					.code(500)
					.message("500 message")
					.responseModel(new ModelRef("string"))
					.build());
			add(new ResponseMessageBuilder()
					.code(403)
					.message("Forbidden!")
					.build());
		}};
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("EICON - Teste")
				.description("Teste para desenvolvedor")
				.version("20191214.1.0.0")
				.contact(new Contact("Akio Tiago Chiuji", "https://www.linkedin.com/in/akio-tiago-chiuji-1b4a3220/", "akiotiago@gmail.com"))
				.license("MIT License")
				.licenseUrl("https://api.github.com/licenses/mit")
				.build();
	}
	
	
}
