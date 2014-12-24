package br.com.alexandreesl.demos;

import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;

public class JsonGeneratorTest {

	public static void main(String[] args) {

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(JsonGenerator.PRETTY_PRINTING, true);

		JsonGeneratorFactory factory = Json.createGeneratorFactory(properties);

		JsonGenerator jsonGen = factory.createGenerator(System.out);

		jsonGen.writeStartObject().write("id", 123)
				.write("descricao", "Produto 1")
				.writeStartObject("Classificacao").write("nivel", 1)
				.write("subnivel", 2).write("secao", "eletrodomesticos")
				.writeEnd().writeStartArray("fornecedores").writeStartObject()
				.write("id", 1).write("descricao", "brastemp").writeEnd()
				.writeStartObject().write("id", 2).write("descricao", "consul")
				.writeEnd().writeStartObject().write("id", 3)
				.write("descricao", "eletrolux").writeEnd().writeEnd()
				.writeEnd().close();

	}

}
