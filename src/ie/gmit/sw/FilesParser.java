package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FilesParser {
	
	String line=null;
	public Map<String, Double> parse (String File) throws NumberFormatException, IOException 
	{
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new InputStreamReader(new FileInputStream("4grams.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while ((line = input.readLine())!= null) {
			
			String[] Score = line.split(" ");
			temp.put(Score[0], Double.parseDouble(Score[1]));	
				
			 }//while
		input.close();
		return temp;
	}	
	
}
