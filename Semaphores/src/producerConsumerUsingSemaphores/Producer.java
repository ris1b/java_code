package producerConsumerUsingSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
	private Queue<Object> store;
	private int capacity;
	String name; // name of the Producer
	Semaphore ps;
	Semaphore cs;

	public Producer(Queue<Object> store, int capacity, String name, Semaphore ps, Semaphore cs) {
		this.store = store;
		this.capacity = capacity;
		this.name = name;
		this.ps = ps;
		this.cs = cs;
	}

	/*
	 * 1 Producer is allowed to produce Shirts indefinitely but store size should be
	 * less than the capacity
	 */
	@Override
	public void run() {
		while (true) {

			try {
				ps.acquire(); // decreasing the number of Producers allowed
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			
			System.out.println(this.name + " adding an Object. Size is " + store.size());
			store.add(new Object());
			
			cs.release(); // increasing the number of Consumer allowed
		}
	}
}
