package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

	public String retrieveFile(String cypherText) throws IOException{
		StringBuilder sb = new StringBuilder(); 	
		File file =new File(cypherText);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String contents; 			
		
		
			while((contents=br.readLine())!=null){ 
			sb.append(contents);
			}
		
		br.close(); 
		cypherText=sb.toString();
		System.out.println(cypherText);
		return cypherText;
		
	}	
}
