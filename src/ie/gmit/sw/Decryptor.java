package ie.gmit.sw;

import java.util.concurrent.*;

public class Decryptor implements Runnable {//producer

	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	private TextScorer tScore;
	
	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;
		this.tScore = new TextScorer(QuadGramMap.QGMap);
	}
	public void run() {
		double score;
		RailFence rf = new RailFence();
		String plainText = rf.decrypt(cypherText, key);
		score = tScore.getScore(plainText);
		Resultable r = new Result(plainText, key, score);
		
		try {
			queue.put(r);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
