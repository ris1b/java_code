package producerConsumerUsingSemaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

import javax.management.RuntimeErrorException;

public class Consumer implements Runnable {
	private Queue<Object> store;
	private int capacity;
	String name;
	Semaphore ps;
	Semaphore cs;

	public Consumer(Queue<Object> store, int capacity, String name, Semaphore ps, Semaphore cs) {
		this.store = store;
		this.capacity = capacity;
		this.name = name;
		this.ps = ps;
		this.cs = cs;
	}

	/*
	 * 1 Consumer can remove more than 1 shirt also
	 */
	@Override
	public void run() {
		while (true) {
			try {
				cs.acquire(); // decreasing the number of Consumer allowed
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println(this.name + " removing an Object. Size is " + store.size());
			store.remove();

			ps.release(); // increasing the number of Producer allowed
		}
	}
}
