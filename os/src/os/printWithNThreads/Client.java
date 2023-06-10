package os.printWithNThreads;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		
		for(int i=1; i<=n; i++) {
			DemoPrinter dp = new DemoPrinter(i);
			Thread t1 = new Thread(dp);
			t1.start();
		}
		
		System.out.println("By Main Thread : " + Thread.currentThread().getName());
		
	}

}
