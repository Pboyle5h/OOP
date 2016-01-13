package ie.gmit.sw;

import java.util.concurrent.BlockingQueue;

public class Cunsumer implements Runnable {
	private Resultable hScore = null;
	private BlockingQueue<Resultable> queue;
	private Resultable result = null;
	private int count;

	public Cunsumer(int count, BlockingQueue<Resultable> queue) {
		super();
		this.count = count;
		this.queue = queue;
	}

	public void run() {
		while (!queue.isEmpty()) {
			try {

				Resultable r = queue.take();
				count--; 
				if (hScore == null || r.getScore() > hScore.getScore()) { 
					hScore = r;

				}
				

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(
				"Plain Text: " + hScore.getPlainText() + "\nKey used to decrypt: " + hScore.getKey() + "\nScore: " + hScore.getScore());

	}
}
