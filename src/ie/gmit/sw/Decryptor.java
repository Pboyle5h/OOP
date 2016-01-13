package ie.gmit.sw;

import java.util.concurrent.*;

public class Decryptor implements Runnable {// producer

	private BlockingQueue<Resultable> queue;
	private String cypherText;
	private int key;
	private TextScorer tScore;
	RailFence rf = new RailFence();

	public Decryptor(BlockingQueue<Resultable> queue, String cypherText, int key) {
		super();
		this.queue = queue;
		this.cypherText = cypherText;
		this.key = key;

	}

	public void run() {
		double score = 0;
		String plainText = rf.decrypt(cypherText, key);
		tScore = new TextScorer(QuadGramMap.QGMap);
		Resultable r = new Result(plainText, key, tScore.getScore(plainText));

		try {
			queue.put(r);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
