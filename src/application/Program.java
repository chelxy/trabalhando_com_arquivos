package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
//vers�o manual
	public static void main(String[] args) {

		//Criar o caminho do meu arquivo
		String path = "c:\\temp\\in.txt";
		//criar uma vari�vel FileReader e inicia com null
		FileReader fr = null;
		//criar o BufferReader e inicia com null
		BufferedReader br = null;
		
		//Criar um bloco try para tentar abrir o arquivo in.txt e ler tamb�m.
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);/*O BufferedReader � instanciado
			a partir do meu FileReader.*/
			//Criar uma String para uma linha do meu arquivo.
			String line = br.readLine();//esse readLine() ler o o arquivo at� o final e retorna null
			
			while(line != null) {
				System.out.println(line);
				//mando ler a linha novamente fazeno um br.readLine
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		//Criar um bloco finally para fechar essa duas streams(FileReader e BufferedReader)
		finally {
			//Ent�o cria-se um bloco try para tratar essa exce��o
			try {
				if(br != null) {
					br.close();//Tipo de exce��o n�o tratada IOException
				}
				if(fr != null) {
					fr.close();//Tipo de exce��o n�o tratada IOException
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
