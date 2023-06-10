package mutexLockEg;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Count count = new Count();
		Lock lock = new ReentrantLock();
		
		Adder adder = new Adder(count, lock);
		Subtracter suber = new Subtracter(count, lock);
		
		Thread t1 = new Thread(adder);
		Thread t2 = new Thread(suber);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		// By using mutex-lock, output will be 0.
		System.out.println(count.value);
		
		
	}

}
