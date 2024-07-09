package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

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
		Map<String, String> map = new HashMap<>();
		ReadWriteLock lock = new ReentrantReadWriteLock();

		executor.submit(() -> {
			lock.writeLock().lock();
			try {
				Thread.sleep(5000); // Ngủ 1 giây
				map.put("foo", "bar");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.writeLock().unlock();
			}
		});

		Runnable readTask = () -> {
			lock.readLock().lock();
			try {
				System.out.println(map.get("foo"));
				Thread.sleep(1000); // Ngủ 1 giây
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				lock.readLock().unlock();
			}
		};

		executor.submit(readTask);
		executor.submit(readTask);

		stop(executor);
	}
}
