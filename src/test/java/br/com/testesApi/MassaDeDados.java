package br.com.testesApi;

public class MassaDeDados {
	String voto_id;
	String urlCadastro = "user/passwordlesssignup";
	String corpoCadastro = "{\"email\": \"emailteste@gmail.com\", \"appDescription\": \"teste the cat api\"}";

	String urlVotacao = "votes/";
	String corpoVotacao = "{\"image_id\": \"6lh\", \"value\": \"true\", \"sub_id\": \"demo-c26f9f\"}";

	String urlDeletaVoto = "votes/{vote_id}";

	String urlFavoritar = "favourites";
	String corpoFavoritar = "{\"image_id\": \"6dt\"}";
	String headerFavoritar = "30d72600-ee68-4289-8fd0-bf39dd39dced";
	
	String urlDesfavoritar = "favourites/{favourite_id}";
	String corpoDesfavoritar = "{\"image_id\": \"6dt\"}";
	String headerDesfavoritar = "30d72600-ee68-4289-8fd0-bf39dd39dced";
}
