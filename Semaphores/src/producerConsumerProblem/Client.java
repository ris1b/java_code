package producerConsumerProblem;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client {

	public static void main(String[] args) {
		// Making a Queue of Objects to be shared with Producer and Consumers
		Queue<Object> store = new ConcurrentLinkedQueue<>();
		int capacity = 5;
		
		// Creating 3 Producers and 4 Consumers
		Producer p1 = new Producer(store, capacity, "p1");
		Producer p2 = new Producer(store, capacity, "p2");
		Producer p3 = new Producer(store, capacity, "p3");
		
		Consumer c1 = new Consumer(store, 0, "c1");
		Consumer c2 = new Consumer(store, 0, "c2");
		Consumer c3 = new Consumer(store, 0, "c3");
		Consumer c4 = new Consumer(store, 0, "c4");
		
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
		 * Producer-Consumer Problem:
		 *
		 * This code implements a basic producer-consumer problem using multiple producer and consumer
		 * threads.
		 * Producers add objects to a shared store, while consumers remove objects from the store.
		 *
		 * Condition to match: 
		 * number of Producer allowed in the store == number of empty slots
		 * number of Consumer allowed in the store == number of filled slots
		 * 
		 * Problem:
		 * A) Producers are able to add more than the number of slots available in the store
		 * 	  i.e. Output: c4 removing an Object. Size is 6
		 *    whereas there are 5 slots in the store.
		 * B) Consumers are able to remove from the store even when there is nothing in the store
		 * 	  ie. Exception : java.util.NoSuchElementException when doing store.remove() due to
		 *    context switching by the CPU.
		 * So there is a synchronization issue where the number of producers
		 * and consumers can exceed the available slots in the store, leading
		 * to inconsistencies and violating the condition to match.
		 *
		 * Explanation:
		 * The current implementation lacks proper synchronization, allowing multiple
		 * producers to add objects even when the available empty slots are insufficient.
		 * Similarly, multiple consumers can attempt to remove objects when the number of
		 * filled slots is insufficient. This violates the intended capacity constraints
		 * of the store.
		 *
		 * Additionally, when the print statements are commented out, there is a potential
		 * race condition where consumers may remove objects from an empty store, and producers
		 * may add more objects than the intended capacity.
		 *
		 * We could use synchronized lock on store to make sure just 1 Producer/Consumer enters:
		 * synchronized (store) {
				if (store.size() < capacity) {
					System.out.println(this.name + " adding an Object. Size is " + store.size());
					store.add(new Object());
				}
			}
			Synchronized has solved the problem, size never goes beyond capacity and never goes
			below 0.
			We can use semaphores to let more than 1 Threads inside the critical section.
		 */

	}

}
