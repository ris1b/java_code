package synchronizedEg;

public class Adder implements Runnable{
	
	Count count;
	
	Adder(Count count) {
		this.count = count;
	}
	
	@Override
	public void run() {
		for(int i=1; i<10000; i++) {
			synchronized(count) {
				count.value += i;	// Critical Section
			}
		}		
	}
	/*
	 * We could lock the entire for loop also, but this is not ideal as it locks the
	 * non-critical section also. */

}
