package readwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite {
	
	
	
	
	public static void read(String filename) {
		Scanner scanner = null;
		try {
			
			scanner = new Scanner(new FileReader("./src/readwrite/" + filename));
			//The delimiter deside where to cut the string when calling scanner.next()
			scanner.useDelimiter("\n");
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file");
		}
		finally {
			scanner.close();
		}
	}
	
	public static void write(String filename) {
		PrintWriter file = null;
		try {
			file = new PrintWriter("./src/readwrite/" + filename);
			for(int x = 0 ; x < 10 ; x++) {
				file.println(x);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The folder in the path did not exist");
		}
		finally {
			file.close();
		}
	}
	
	public static void main(String[] args) {
		read("file.txt");
		write("file2.txt");
	}
}
