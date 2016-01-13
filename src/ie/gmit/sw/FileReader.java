package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
	// Retrive file used to retrieve the file in which the user enters in the
	// runner classw
	public String retrieveFile(String cypherText) throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File(cypherText);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String contents;

		// while the fille is not empty append on to the end of the String
		// Builder
		while ((contents = br.readLine()) != null) {
			sb.append(contents);
		}

		br.close();
		cypherText = sb.toString();
		return cypherText;

	}
}
