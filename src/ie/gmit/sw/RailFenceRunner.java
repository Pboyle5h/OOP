package ie.gmit.sw;

import java.io.IOException;
import java.util.Scanner;

public class RailFenceRunner {
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		QuadGramMap.fillMap(); 
		String fileIn ="";
		String efile="";
		boolean valid=true;
		
		while(valid){
			System.out.println("Enter file name of the file containing the enrypted text:");
			fileIn = console.next();
			FileReader fr = new FileReader();
				try {
					efile=fr.retrieveFile(fileIn);
					CypherBreaker cb = new CypherBreaker(efile);
					valid=false;
				} catch (IOException e) {
					System.out.println("Unable to open File");
				}
				
		}
		
		
	}

}
