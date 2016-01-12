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
//		new Thread(new Runnable()
//		{
//			public void run() {
//				while(!queue.isEmpty())
//				{	
//					try {
//						Resultable r = queue.take();
//						/*
//						 * create poisonResult class that implements Resultable 
//						 * white diamond straight line uml connection to result
//						 * 
//						 * MUTEX LOCK a volatile counter and increment until counter is the size of the 
//						 * blocking queue was at the start
//						 * when the numbers are the same, put a poisonResult into queue to kill it off
//						 */
//						if(r instanceof /*Poison*/Result)
//						{
//							return;
//						}
//						//do something......
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		});
	}
}
