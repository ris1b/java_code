package os.print1toN;

public class NumberPrinter implements Runnable{
	private int numberToPrint;
	
	public NumberPrinter(int numberToPrint) {
		this.numberToPrint = numberToPrint;
	}
	@Override
	public void run() {
		System.out.println(numberToPrint + " printed by : " + Thread.currentThread().getName());
	}

}
