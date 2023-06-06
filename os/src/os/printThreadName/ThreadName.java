package os.printThreadName;

public class ThreadName {

	public static void main(String[] args) {
		/*
		 * Every process has a main thread.*/
		System.out.println("Main thread name is: " + Thread.currentThread().getName());
	}

}
