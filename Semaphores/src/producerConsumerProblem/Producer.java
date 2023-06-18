package producerConsumerProblem;

import java.util.Queue;

public class Producer implements Runnable {
	private Queue<Object> store;
	private int capacity;
	String name; // name of the Producer

	public Producer(Queue<Object> store, int capacity, String name) {
		this.store = store;
		this.capacity = capacity;
		this.name = name;
	}

	/*
	 * 1 Producer is allowed to produce Shirts indefinitely but store size should be
	 * less than the capacity
	 */
	@Override
	public void run() {
		while (true) {
//			synchronized (store) {
				if (store.size() < capacity) {
					System.out.println(this.name + " adding an Object. Size is " + store.size());
					store.add(new Object());
				}
//			}
		}
	}
}
