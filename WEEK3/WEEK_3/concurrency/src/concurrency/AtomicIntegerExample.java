package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AtomicIntegerExample {
	public static void main(String[] args) {
		// Tạo một AtomicInteger với giá trị ban đầu là 0
		AtomicInteger atomicInt = new AtomicInteger(0);

		// Tạo một ExecutorService với một fixed thread pool gồm 3 luồng
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Sử dụng IntStream để lặp qua 1000 phần tử
		IntStream.range(0, 1000).forEach(i -> {
			// Tạo một tác vụ Runnable để tăng giá trị của atomicInt lên 2
			Runnable task = () -> atomicInt.updateAndGet(n -> n + 2);
			// Đệ trình (submit) tác vụ tới ExecutorService
			executor.submit(task);
		});

		// Dừng ExecutorService
		stop(executor);

		// In ra giá trị của atomicInt
		System.out.println(atomicInt.get()); // => 2000
	}

	// Phương thức để dừng ExecutorService một cách gọn gàng
	private static void stop(ExecutorService executor) {
		try {
			// Yêu cầu không nhận thêm tác vụ mới
			executor.shutdown();
			// Chờ cho các tác vụ đang chạy hoàn thành trong 1 phút
			if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
				// Buộc ExecutorService dừng ngay lập tức nếu không hoàn thành trong thời gian
				// chờ
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			// Buộc ExecutorService dừng ngay lập tức nếu có lỗi
			executor.shutdownNow();
		}
	}
}
