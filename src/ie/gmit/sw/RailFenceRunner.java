package ie.gmit.sw;

import java.io.IOException;
import java.util.Scanner;

public class RailFenceRunner {
	static Scanner console = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		String fileIn ="";
		String efile="";
		boolean valid=true;
		
		while(valid){
			System.out.println("Enter file name of the file containing the enrypted text:");
			fileIn = console.next();
			FilesParser fp = new FilesParser();
				try {
					efile=fp.retrieveFile(fileIn);
					valid=false;
				} catch (IOException e) {
					System.out.println("Unable to open File");
				}
				
		}
		
		
	}

}
