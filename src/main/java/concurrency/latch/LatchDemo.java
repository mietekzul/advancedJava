package concurrency.latch;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class LatchDemo {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch endSignal = new CountDownLatch(5);

		IntStream.range(0, 5).forEach(e -> new Thread(new Worker(e, startSignal, endSignal)).start());

		System.out.println("Work done before starting workers...");
		startSignal.countDown();
		System.out.println("Doing work while workers are running");
		endSignal.await();
		System.out.println("All workers finished");
	}
}
