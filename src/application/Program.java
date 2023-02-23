package application;

import java.io.File;
import java.util.Scanner;

public class Program {
//Manipulando pastas com File
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a folder path: ");
		String strPath = sc.nextLine();

		File path = new File(strPath);
		// listar o que for diretório
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("Folders:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		//Listar a lista de arquivos
		File[] files = path.listFiles(File::isFile);
		System.out.println("Files:");
		for (File file : files) {
			System.out.println(file);	
		}
		
		//Criar uma subpasta a partir da pasta temp
		boolean success = new File(strPath + "\\subfolder").mkdir();
		System.out.println("Directory created successfully: " + success);

		sc.close();
	}
}
