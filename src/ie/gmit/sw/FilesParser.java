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

	String line = null;

	// parse method is used to read in the 4grams.txt and put it into a map
	public Map<String, Double> parse(String File) throws NumberFormatException, IOException {
		Map<String, Double> temp = new ConcurrentHashMap<String, Double>();
		BufferedReader input = null;
		try {
			// stores the full text into the string input
			input = new BufferedReader(new InputStreamReader(new FileInputStream("4grams.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// read through each line in the string untill its finished
		while ((line = input.readLine()) != null) {
			// splits the text up when there a space
			String[] Score = line.split(" ");
			// the first text is the 4 characters and the second one is the
			// score.
			temp.put(Score[0], Double.parseDouble(Score[1]));

		} // while
		input.close();
		return temp;
	}

}
