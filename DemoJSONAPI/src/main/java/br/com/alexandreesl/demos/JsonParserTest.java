package br.com.alexandreesl.demos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JsonParserTest {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream file = new FileInputStream("produtos.json");

		JsonParser parser = Json.createParser(file);

		while (parser.hasNext()) {
			Event evento = parser.next();

			switch (evento) {
			case KEY_NAME: {
				System.out.println(parser.getString() + ":");
				break;
			}
			case VALUE_STRING: {
				System.out.println(parser.getString());
				break;
			}
			case VALUE_NUMBER: {
				System.out.println(parser.getString());
				break;
			}
			case VALUE_NULL: {
				System.out.println("null");
				break;
			}
			case START_ARRAY: {
				System.out.println("começo de um array");
				break;
			}
			case END_ARRAY: {
				System.out.println("final de um array");
				break;
			}
			case END_OBJECT: {
				System.out.println("Final do Objeto Json");
				break;
			}

			}

		}

	}

}
