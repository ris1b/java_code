package os.printWithExecutorService;

public class DemoPrinter implements Runnable{
	private int numToPrint;
	
	public DemoPrinter(int numToPrint) {
		this.numToPrint = numToPrint;
	}

	@Override
	public void run() {
		// the code here would run on a separate thread.
		System.out.println(numToPrint + " printed by " + Thread.currentThread().getName());
	}

}
