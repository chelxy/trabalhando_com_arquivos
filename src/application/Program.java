package application;

import java.io.File;
import java.util.Scanner;

public class Program {
//Informações do caminho do arquivo
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a file path: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);

		System.out.println("getName: " + path.getName());//somente o nome do arquivo
		System.out.println("getParent: " + path.getParent());//somente o caminho
		System.out.println("getPath: " + path.getPath());//todo o caminho

		sc.close();
	}
}
