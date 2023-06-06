package os.printWith2Threads;

public class DemoPrinter implements Runnable{

	private void doSomeThing() {
		System.out.println("from4 "  + Thread.currentThread().getName());
	}
	
	@Override
	public void run() {
		// the code here would run on a separate thread.
		System.out.println("From3 : " + Thread.currentThread().getName());
		doSomeThing();
	}

}
