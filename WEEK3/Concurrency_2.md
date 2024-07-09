## Race condition

- Race condition xảy ra khi hai hoặc nhiều luồng truy cập dữ liệu chia sẻ và cố gắng thay đổi nó đồng thời. Kết quả cuối cùng phụ thuộc vào thứ tự truy cập, có thể dẫn đến kết quả không nhất quán.

- Ví dụ:

```
class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
```

```
public class RaceConditionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
```

Trong ví dụ trên, hai thread (thread1 và thread2) đều thực hiện việc tăng biến count trong đối tượng Counter. Kết quả cuối cùng của biến count có thể không phải là 2000 như mong đợi, vì các thread có thể truy cập và thay đổi giá trị của count đồng thời, gây ra race condition.

- 1 số cách khắc phục Race Condition:

  - Sử dụng `synchronized`:

    - **Synchronized Methods**: Đánh dấu phương thức bằng từ khóa `synchronized` để đảm bảo rằng chỉ có một luồng được phép truy cập vào phương thức đó tại một thời điểm.

    ```
    public synchronized void synchronizedMethod() {
    // critical section
    }
    ```

    - **Synchronized Blocks**: Đặt đoạn mã cần bảo vệ trong một khối `synchronized` để đồng bộ hóa trên một đối tượng cụ thể.

    ```
    public void someMethod() {
    synchronized(this) {
        // critical section
    }
    }
    ```

  - Sử dụng `Lock`
  - Sử dụng `Atomic Variables`:

    - Các lớp như AtomicInteger, AtomicLong, và AtomicReference cung cấp các phương thức nguyên tử để thực hiện các thao tác mà không cần đồng bộ hóa.

    ```
    import java.util.concurrent.atomic.AtomicInteger;

    public class SomeClass {
        private final AtomicInteger counter = new AtomicInteger(0);

        public void increment() {
            counter.incrementAndGet();
        }

        public int getCounter() {
            return counter.get();
        }
    }
    ```

- Sử dụng `Concurrent Collections`
- Sử dụng `volatile` Keyword: Từ khóa volatile đảm bảo rằng các thay đổi trên biến sẽ được nhìn thấy ngay lập tức bởi các luồng khác.

```
private volatile boolean flag = true;

public void someMethod() {
    while (flag) {
        // do something
    }
}
```

## Lock

- `Lock` cung cấp cơ chế để kiểm soát quyền truy cập vào một tài nguyên chia sẻ bởi nhiều luồng.
- Nó đảm bảo rằng chỉ có một luồng có thể truy cập tài nguyên tại một thời điểm, ngăn chặn tình trạng `race condition`.
- Java cung cấp nhiều kiểu khóa khác nhau:

  - `ReentrantLock`: là một loại `lock` (khóa) có khả năng tái nhập (reentrant), có nghĩa là một luồng (thread) có thể nắm giữ nó nhiều lần và chỉ giải phóng khi nó đã được giải phóng bởi tất cả các lần nắm giữ.

  ```
  import java.util.concurrent.locks.ReentrantLock;

    public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 1 acquired the lock");
                Thread.sleep(1000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread 1 released the lock");
            }
        });

        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread 2 acquired the lock");
            } finally {
                lock.unlock();
                System.out.println("Thread 2 released the lock");
            }
        });

        thread1.start();
        thread2.start();
    }
    }
  ```

Trong ví dụ này, hai luồng thread1 và thread2 sử dụng cùng một ReentrantLock. Luồng thread1 đầu tiên sẽ nắm giữ lock và sau đó giải phóng nó sau khi hoàn thành công việc. Sau đó, luồng thread2 sẽ nắm giữ và giải phóng lock.

Điểm mạnh của ReentrantLock là bạn có thể kiểm soát được khi nào thả lock bằng cách sử dụng khối try-finally như trong ví dụ trên. Tuy nhiên, bạn cần chắc chắn rằng mọi lần nắm giữ đều _có khối finally để đảm bảo lock được giải phóng_ dù có xảy ra ngoại lệ hay không.

- `ReadWriteLock`:

  - là một giao diện (interface) cho phép bạn có được nhiều đọc cùng một lúc nhưng chỉ một viết duy nhất tại một thời điểm.
  - Điều này hữu ích khi bạn có một tập dữ liệu mà nhiều luồng (thread) có thể đọc cùng một lúc nhưng chỉ một luồng có thể thay đổi nó vào một thời điểm nhất định.
  - `ReadWriteLock` có hai loại lock bên trong:
    - `ReadLock`: Cho phép nhiều luồng cùng nắm giữ để đọc dữ liệu.
    - `WriteLock`: Yêu cầu lock độc quyền để thay đổi dữ liệu.
  - `ReadWriteLock` cho phép nhiều luồng đọc cùng một lúc (nếu không có ai đang viết), nhưng chỉ một luồng có thể viết một lúc. Khi không có luồng nào đang viết, nhiều luồng có thể đọc cùng lúc.

  ```
  import java.util.concurrent.locks.ReadWriteLock;
  import java.util.concurrent.locks.ReentrantReadWriteLock;

    public class ReadWriteLockExample {
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int data = 0;

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            lock.writeLock().lock();
            try {
                System.out.println("Writer thread is writing data.");
                data++; // Modifying the shared resource
                Thread.sleep(1000); // Simulating some write operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
                System.out.println("Writer thread released the write lock.");
            }
        });

        Thread readerThread = new Thread(() -> {
            lock.readLock().lock();
            try {
                System.out.println("Reader thread is reading data: " + data); // Reading the shared resource
                Thread.sleep(1000); // Simulating some read operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
                System.out.println("Reader thread released the read lock.");
            }
        });

        writerThread.start();
        readerThread.start();
    }

    }

  ```

- `StampedLock`: Một loại khóa dựa trên khả năng với ba chế độ để kiểm soát truy cập đọc/ghi.

## Atomic Integer

## Concurrent HashMap

## Virtual Thread

- Java 21 giới thiệu virtual threads, những luồng nhẹ nhằm làm cho lập trình đồng thời trở nên dễ dàng và mở rộng hơn. Virtual threads được quản lý bởi Java runtime, cho phép tạo ra hàng ngàn hay thậm chí hàng triệu luồng mà không gây quá tải đáng kể.

```

public class VirtualThreadExample {
public static void main(String[] args) {
for (int i = 0; i < 1000; i++) {
Thread.startVirtualThread(() -> {
System.out.println("Running in a virtual thread: " + Thread.currentThread());
});
}
}
}

```

- Virtual threads cung cấp một mô hình đơn giản hơn cho xử lý đồng thời, làm cho việc viết và duy trì các ứng dụng đồng thời trở nên dễ dàng hơn mà không cần lo lắng về quản lý luồng và hạn chế tài nguyên.

https://viblo.asia/p/virtual-threads-nen-tang-moi-cho-ung-dung-java-quy-mo-lon-5pPLkxA8VRZ

```

```
