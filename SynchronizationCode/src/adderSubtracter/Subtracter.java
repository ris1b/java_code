package adderSubtracter;

public class Subtracter implements Runnable {

	Count count;

	Subtracter(Count count) {
		this.count = count;
	}

	@Override
	public void run() {
		for(int i=1; i<10000; i++) {
			count.value -= i;
		}
	}

}
