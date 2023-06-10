package synchronizedEg;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		Count count = new Count();
		
		Adder adder = new Adder(count);
		Subtracter suber = new Subtracter(count);
		
		Thread t1 = new Thread(adder);
		Thread t2 = new Thread(suber);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		// By using synchronized, output will be 0.
		System.out.println(count.value);
		
		
	}

}
