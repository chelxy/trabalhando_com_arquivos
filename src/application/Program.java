package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
//Bloco try-with-resources
	public static void main(String[] args) {

		// Criar o caminho do meu arquivo
		String path = "c:\\temp\\in.txt";

		// Criar um bloco try para tentar abrir o arquivo in.txt e ler também.
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			// Criar uma String para uma linha do meu arquivo.
			String line = br.readLine();// esse readLine() ler o o arquivo até o final e retorna null

			while (line != null) {
				System.out.println(line);
				// mando ler a linha novamente fazeno um br.readLine
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}
}
