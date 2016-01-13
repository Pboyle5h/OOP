package ie.gmit.sw;

import java.io.IOException;
import java.util.Scanner;

public class RailFenceRunner {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader();// Create an instanse of File Reader
		Scanner console = new Scanner(System.in);// Creates the scanner so the
													// users input can be read
		QuadGramMap.fillMap();// calls the Fill Map method which fills the the
								// map with 4grams.txt
		String fileIn = "";
		String efile = "";
		boolean valid = true;

		// while valid = true it keeps looping through until the user enter the
		// correct text file which is example.txt
		while (valid) {
			System.out.println("Enter file name of the file containing the enrypted text:");
			fileIn = console.next();

			try {
				// send the fillname over to the file reader class so that the
				// contents can be recieved
				efile = fr.retrieveFile(fileIn);
				// creates an instanse of Cypher Breaker and sends the Encrypted
				// file to the class
				CypherBreaker cb = new CypherBreaker(efile);
				// if it works valid changes to false and the while loop can end
				valid = false;
			} catch (IOException e) {
				System.out.println("Unable to open File");
			}

		}

	}

}
