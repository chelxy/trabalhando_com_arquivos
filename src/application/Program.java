package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		File file = new File("c:\\temp\\in.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			// testar se ainda existe uma nova linha no arquivo
			while (sc.hasNextLine()) {
				// imprimir a linha do arquivo
				System.out.println(sc.nextLine());
			}
			// sc.close();
			/*
			 * Se eu colocar o sc.close aqui, pode ocorrer algum erro, pular para o bloco
			 * catch e não fechar o Scanner.
			 */

		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
		// Por isso cria um bloco finally para fechar o Scanner. Isso é uma boa prática.
		finally {
			/*tem que colocar o sc.close dentro de um if para não dar um nullPointerException, 
			pois o sc vai tá valendo null*/
			if (sc != null) {
				sc.close();
			}
		}
	}

}
