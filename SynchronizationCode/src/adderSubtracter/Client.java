package adderSubtracter;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Count count = new Count();
		
		Adder adder = new Adder(count);
		Subtracter suber = new Subtracter(count);
		
		Thread t1 = new Thread(adder);
		Thread t2 = new Thread(suber);
		
		t1.start();
		t2.start();
		
		// calling join, as we want both the threads to finish
		// to print the value of count
		t1.join();
		t2.join();
		
		System.out.println(count.value);
		
		
	}

}
