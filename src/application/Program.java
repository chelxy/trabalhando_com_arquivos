package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		String[] lines = new String[] { "Good morning", "Good afternoon", "Good night" };

		String path = "c:\\temp\\out.txt";
		
		/*Cria/recria o arquivo: new FileWriter(path)
		Acrescenta ao arquivo existente: new FileWriter(path, true)*/

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (String line : lines) {
				bw.write(line);// escrever a linha no arquivo
				bw.newLine();// quebra de linha
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
