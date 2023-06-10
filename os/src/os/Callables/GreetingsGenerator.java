package os.Callables;

import java.util.Random;
import java.util.concurrent.Callable;

/*
 * Would be invoked on different threads and would give different greetings*/
public class GreetingsGenerator implements Callable<String>{
	
	private Random random;
	
	public GreetingsGenerator(Random random) {
		this.random = random;
	}

	@Override
	public String call() throws Exception {
		int num = random.nextInt(5);
		
		if(num == 1) {
			return "hello " + Thread.currentThread().getName();
		} else if (num == 2) {
			return "hi " + Thread.currentThread().getName();
		} else if(num == 3) {
			return "namaste "+ Thread.currentThread().getName();
		} else if(num == 4) {
			return "hola " + Thread.currentThread().getName();
		} else if(num == 5) {
			return "what's up "+ Thread.currentThread().getName();
		} else {
			return "no greeting " + Thread.currentThread().getName();
		}
	}
}
