package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

	public static void stop(ExecutorService executor) {
		// Ngừng nhận nhiệm vụ mới và hoàn thành các nhiệm vụ đang chờ
		executor.shutdown();
		try {
			// Đợi các tác vụ hoàn thành trong một khoảng thời gian nhất định
			if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
				// Buộc ngừng tất cả các tác vụ nếu không thể hoàn thành trong thời gian chờ
				executor.shutdownNow();
				// Đợi thêm một khoảng thời gian để các tác vụ buộc ngừng
				if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
					System.err.println("Executor did not terminate");
				}
			}
		} catch (InterruptedException ie) {
			// Buộc ngừng nếu bị gián đoạn trong khi đang chờ
			executor.shutdownNow();
			// Khôi phục trạng thái gián đoạn
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ReentrantLock lock = new ReentrantLock();

		executor.submit(() -> {
			lock.lock();
			try {
				Thread.sleep(1000); // Ngủ 1 giây
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				lock.unlock();
			}
		});

		executor.submit(() -> {
			System.out.println("Locked: " + lock.isLocked());
			System.out.println("Held by me: " + lock.isHeldByCurrentThread());
			boolean locked = lock.tryLock();
			System.out.println("Lock acquired: " + locked);
		});

		stop(executor);
	}
}
