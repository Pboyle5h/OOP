package ie.gmit.sw;

import java.util.concurrent.*;


public class CypherBreaker {
	private static final int MAX_QUEUE_SIZE = 100;
	private BlockingQueue<Resultable> queue;
	private String cypherText;
	public CypherBreaker(String cypherText)
	{
		queue = new ArrayBlockingQueue<Resultable>(MAX_QUEUE_SIZE);
		this.cypherText =cypherText;
		init();
	}
	public void init()
	{
		
		for(int i=2; i<cypherText.length()/2; i++)
		{
			new Thread(new Decryptor(queue, cypherText, i)).start();
		}
		Thread t = new Thread(new Cunsumer(cypherText.length()/2, queue)); 
		t.start(); //start thread
	}
}
