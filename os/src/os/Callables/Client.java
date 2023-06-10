package os.Callables;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Random random = new Random();
		
		GreetingsGenerator gg = new GreetingsGenerator(random);
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		List<Future<String>> futureGreeting = new ArrayList<>();
		
		for(int i=0; i<99; i++) {
			Future<String> promiseOfGreeting = executorService.submit(gg);
			futureGreeting.add(promiseOfGreeting);
		}
		
		for(Future<String> greetingPromise : futureGreeting) {
			String greeting = greetingPromise.get();
			System.out.println(greeting);
		}
		executorService.shutdown();
	}

}
