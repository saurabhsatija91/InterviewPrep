package Assignment1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class SearchWord {
	public static Scanner input;
	
	public static void main(String[] args) {
		String temp;
		int count = 0;
		Scanner userInput = new Scanner(System.in);
		String word;
		System.out.println("Enter the word you want to search.");
		word = userInput.next();
		
		JFileChoose application = new JFileChoose();
		File name = application.get();
		System.out.println(name);
		
		try {
			input = new Scanner(name);
			input.useDelimiter(System.getProperty("line.separator"));
			while (input.hasNext()) {
				count++;
				String line = input.next();
				StringTokenizer tokenizer = new StringTokenizer(line, " ,.?!:;");
				while (tokenizer.hasMoreTokens()) {
					temp = tokenizer.nextToken();
					if (temp.equalsIgnoreCase(word)) {
						System.out.println("line " + count + ", " + line);
					}
				}
			} 
			
		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("Error openign file: " +
		fileNotFoundException.toString());
			System.exit(1);
		}
		finally {
			input.close();
			userInput.close();
		}
		
		System.exit(0);
	}
}
