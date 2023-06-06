package os.printWith2Threads;

public class Client {

	public static void main(String[] args) {
		System.out.println("From1 : " + Thread.currentThread().getName());
		
		// making object of DemoPrinter
		DemoPrinter dp = new DemoPrinter();
//		dp.run();		// invokes run() on the same thread.
		
		// making object of Thread
		Thread t1 = new Thread(dp);
		
		t1.start();		// invokes run() on a separate thread.
		
		System.out.println("From2 : " + Thread.currentThread().getName());
	}

}
