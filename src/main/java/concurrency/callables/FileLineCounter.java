package concurrency.callables;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FileLineCounter {

	private Path dir = Paths.get("src", "main", "java", "oop");

	private long computeTotalNumberOfLines() {
		long total = 0;

		try {
			total = executeCounters().stream()
					.mapToLong(this::extractValueFromFuture)
					.sum();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
		return total;
	}

	private List<Future<Long>> executeCounters() throws InterruptedException, IOException {
		ExecutorService service = Executors.newCachedThreadPool();
		long start = System.currentTimeMillis();
		List<Future<Long>> futures = service.invokeAll(getFileLineCounters());
		service.shutdown();
		System.out.println("Time spent for counting: " + (System.currentTimeMillis() - start));
		return futures;
	}

	private List<Callable<Long>> getFileLineCounters() throws IOException {
		return Files.list(dir)
				.filter(Files::isRegularFile)
				.map(this::callablePrintingCounter)
				.collect(Collectors.toList());
	}

	private Callable<Long> callableCounter(Path path) {
		return () -> Files.lines(path).count();
	}

	private Callable<Long> callablePrintingCounter(Path path) {
		return () -> {
			long count = Files.lines(path).count();
			System.out.printf("%s has %d lines using thread: %s %n", path, count, Thread.currentThread().getName());

			return count;
		};
	}

	private long extractValueFromFuture(Future<Long> longFuture) {
		long val = 0;
		try {
			return longFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return val;
	}

	public static void main(String[] args) {
		FileLineCounter demo = new FileLineCounter();
		System.out.printf("Total number of lines: %d%n", demo.computeTotalNumberOfLines());
	}
}
