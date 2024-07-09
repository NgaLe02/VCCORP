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

## Lock

## Atomic Integer

## Concurrent HashMap

## Virtual Thread
