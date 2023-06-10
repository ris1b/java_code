package os.printWithExecutorService;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import os.printWithNThreads.DemoPrinter;

public class Client {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		// Here, we would use 10 threads to do n tasks
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for (int i = 1; i <= n; i++) {
			DemoPrinter dp = new DemoPrinter(i);
			executorService.execute(dp);
		}
		executorService.shutdown();

		System.out.println("By Main Thread : " + Thread.currentThread().getName());
	}

}
