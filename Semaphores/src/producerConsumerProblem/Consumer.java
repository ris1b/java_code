package producerConsumerProblem;

import java.util.Queue;

public class Consumer implements Runnable {
	private Queue<Object> store;
	private int capacity;
	String name;

	public Consumer(Queue<Object> store, int capacity, String name) {
		this.store = store;
		this.capacity = capacity;
		this.name = name;
	}

	/*
	 * 1 Consumer can remove more than 1 shirt also
	 */
	@Override
	public void run() {
		while (true) {
//			synchronized (store) {
				if (store.size() > 0) {
					System.out.println(this.name + " removing an Object. Size is " + store.size());
					store.remove();
				}
//			}
		}
	}
}
