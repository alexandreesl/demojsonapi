package br.com.alexandreesl.demos;

import java.io.FileNotFoundException;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class JsonGeneratorObjectTest {

	public static void main(String[] args) throws FileNotFoundException {

		JsonBuilderFactory jBuilderFactory = Json.createBuilderFactory(null);
		JsonObjectBuilder jObjectBuilder = jBuilderFactory
				.createObjectBuilder();
		jObjectBuilder
				.add("id", 123)
				.add("descricao", "Produto 1")
				.add("Classificacao",
						jBuilderFactory.createObjectBuilder().add("nivel", 1)
								.add("subnivel", 2)
								.add("secao", "eletrodomesticos"))
				.add("fornecedores",
						jBuilderFactory
								.createArrayBuilder()
								.add(jBuilderFactory.createObjectBuilder()
										.add("id", 1)
										.add("descricao", "brastemp"))
								.add(jBuilderFactory.createObjectBuilder()
										.add("id", 2)
										.add("descricao", "consul"))
								.add(jBuilderFactory.createObjectBuilder()
										.add("id", 3)
										.add("descricao", "eletrolux")));
		JsonObject jObject = jObjectBuilder.build();

		JsonWriter jWriterOut = Json.createWriter(System.out);
		jWriterOut.writeObject(jObject);
		jWriterOut.close();
	}

}
