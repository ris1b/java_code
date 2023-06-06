package os.print1toN;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			NumberPrinter number = new NumberPrinter(i);
			
			Thread t = new Thread(number);
			t.start();
		}
		
		System.out.println("Last statement by : " + Thread.currentThread().getName());
		
	}

}
