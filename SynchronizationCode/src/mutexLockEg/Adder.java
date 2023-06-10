package mutexLockEg;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
	
	Count count;
	Lock lock;
	
	Adder(Count count, Lock lock) {
		this.count = count;
		this.lock = lock;
	}
	
	@Override
	public void run() {
		for(int i=1; i<10000; i++) {
			lock.lock();
			
			count.value += i;	// Critical Section
			
			lock.unlock();
		}		
	}
	/*
	 * We could lock the entire for loop also, but this is not ideal as it locks the
	 * non-critical section also. */

}
