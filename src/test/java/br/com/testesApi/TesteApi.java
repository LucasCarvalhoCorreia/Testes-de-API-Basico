package br.com.testesApi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TesteApi extends MassaDeDados{
	
	@BeforeClass
	public static void urlBase() {
		RestAssured.baseURI = "http://api.thecatapi.com/v1/";
	}

	@Test
	public void cadastro() {
		//Dado
		Response response = given().contentType("application/json").body(corpoCadastro).
		
		//Quando
		when().post(urlCadastro);
		
		//Então
		validacao(response);
	}
	
	@Test
	public void votacao() {
		//Dado
		Response response = 
				given().contentType("application/json")
				.body(corpoVotacao).
		
		//Quando
		when().post(urlVotacao);
		
		//Então
		validacao(response);
		
		String id = response.jsonPath().getString("id");
		voto_id = id;
		
		System.out.println("ID: " +id);
	}

	@Test
	public void deletarVotacao() {
		votacao();
		deletaVoto();
	}

	private void deletaVoto() {
		//Dado
		Response response = 
		given()
		.contentType("application/json")
		.header("x-api-key", "30d72600-ee68-4289-8fd0-bf39dd39dced")
		.pathParam("vote_id", voto_id)
						
		//Quando
		.when().delete(urlDeletaVoto);
		
		//Então
		validacao(response);
	}
	
	@Test
	public void favoritarDesfavoritar() {
		favoritar();
		desfavoritar();
	}
	
	private void favoritar() {
		//Given
		Response response =
				given()
				.contentType("application/json")
				.header("x-api-key", headerFavoritar)
				.body(corpoFavoritar)
		
		//When
		.when().post(urlFavoritar);
				
		//Then
		
		String id = response.jsonPath().getString("id");
		voto_id = id;
		
		validacao(response);
	}

	private void desfavoritar() {
		//Given
		Response response =
				given()
				.contentType("application/json")
				.header("x-api-key", headerDesfavoritar)
				.pathParam("favourite_id", voto_id)
				.body(corpoDesfavoritar)
		
		//When
		.when().delete(urlDesfavoritar);
				
		//Then
		validacao(response);
		
	}
	
	public void validacao(Response response) {
		response.then().statusCode(200).body("message", containsString("SUCCESS"));
		System.out.println("Retorno da API: " +response.body().asString());
		System.out.println("--------------------------------------------------");
	}

}
