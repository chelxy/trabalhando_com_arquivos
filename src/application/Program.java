package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<Product>();

		System.out.print("Enter file path: ");
		String strPath = sc.nextLine();

		File file = new File(strPath);
		String onlyPath = file.getParent();

		boolean success = new File(onlyPath + "\\out").mkdir();
		String fullPath = onlyPath + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {

			String read = br.readLine();
			while (read != null) {
				String[] fields = read.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));

				read = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(fullPath))) {

				for (Product item : list) {
					bw.write(item.getName() + ", " + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(fullPath + " Created!");
				
			} catch (IOException e) {
				System.out.println("File writing error " + e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Error reading the file " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}
