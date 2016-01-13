package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Cunsumer implements Runnable {
	private Resultable hScore = null;
	private BlockingQueue<Resultable> queue;
	private Resultable result = null;
	private int count;

	// blocking queue passed into the class
	public Cunsumer(int count, BlockingQueue<Resultable> queue) {
		super();
		this.count = count;
		this.queue = queue;
	}

	public void run() {
		while (!queue.isEmpty()) {// while queue isnt empty execute
			try {
				// takes the result from the queue
				Resultable r = queue.take();
				count--;
				// to get the high we just check to see if the score is greater
				// than the high score if so then thats the new high score
				if (hScore == null || r.getScore() > hScore.getScore()) {
					hScore = r;

				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// prints out the best result
		System.out.println("Plain Text: " + hScore.getPlainText() + "\nKey used to decrypt: " + hScore.getKey()
				+ "\nScore: " + hScore.getScore());

	}
}
