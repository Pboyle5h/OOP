package ie.gmit.sw;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QuadGramMap {
	public static int GRAM_SIZE = 4;

	public static Map<String, Double> QGMap = new ConcurrentHashMap<String, Double>();

	public static void fillMap() {
		String File = "4grams.txt";
		FilesParser fp = new FilesParser();
		try {
			QGMap = fp.parse(File);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// end fillMap
}
