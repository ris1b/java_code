package synchronizedEg;

public class Subtracter implements Runnable {

	Count count;
	
	Subtracter(Count count) {
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=1; i<10000; i++) {
			synchronized(count) {
				count.value -= i;	// Critical Section
			}
		}
	}

}
