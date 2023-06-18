package producerConsumerUsingSemaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class Client {

	public static void main(String[] args) {
		// Making a Queue of Objects to be shared with Producer and Consumers
		Queue<Object> store = new ConcurrentLinkedQueue<>();
		int capacity = 5;
		
		
		Semaphore ps = new Semaphore(capacity);	// Producer Semaphore, initially 5 Producers allowed
		Semaphore cs = new Semaphore(0);		// Consumer Semaphore, initially 0 Consumers allowed	
		
		// Passing the semaphores to Producers and Consumers which would be used for synchronizing
		Producer p1 = new Producer(store, capacity, "p1", ps, cs);
		Producer p2 = new Producer(store, capacity, "p2", ps, cs);
		Producer p3 = new Producer(store, capacity, "p3", ps, cs);
		
		Consumer c1 = new Consumer(store, 0, "c1", ps, cs);
		Consumer c2 = new Consumer(store, 0, "c2", ps, cs);
		Consumer c3 = new Consumer(store, 0, "c3", ps, cs);
		Consumer c4 = new Consumer(store, 0, "c4", ps, cs);
		
		// Creating Threads
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		Thread t4 = new Thread(c1);
		Thread t5 = new Thread(c2);
		Thread t6 = new Thread(c3);
		Thread t7 = new Thread(c4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		
		/*
		 * Synchronization is achieved and using Semaphore we
		 * are allowing more than 1 thread in the critical section
		 * at the same time*/

	}

}
