## Đa luồng trong Java

- Đa luồng (Multi-Thread) trong Java là khả năng của một ứng dụng để thực hiện nhiều luồng đồng thời. Thay vì thực hiện công việc tuần tự từ trên xuống dưới, ứng dụng Java có thể chạy nhiều luồng đồng thời, làm cho ứng dụng chạy nhanh và hiệu quả hơn.

![alt text](image-7.png)

- Ví dụ, một ứng dụng nghe nhạc có thể chạy một luồng để phát nhạc và một luồng khác để tải bài hát mới về máy cùng lúc. Điều này giúp người dùng có thể nghe nhạc mà không cần chờ quá lâu để tải bài hát mới.

### Tiến trình (Process)

- Tiến trình là một chương trình đang được thực thi, tức là một chương trình đang hoạt động.

### LUồng (Thread)

- Một luồng(thread) là đơn vị thực thi nhỏ nhất trong một tiến trình.

### Mối quan hệ Process và Thread

![alt text](image-8.png)

- 1. Chương trình chứa 1 tập các instruction.
- 2. Chương trình được nạp vào bộ nhớ, nó trở thành một hoặc nhiều tiến trình đang chạy.
- 3. Khi một tiến trình bắt đầu, nó được gán bộ nhớ và tài nguyên cần thiết. Một tiến trình(process) có thể có 1 hoặc nhiều luồng(thread), nhưng mỗi luồng chỉ thuộc về một tiến trình duy nhất.
- Ví dụ: trong ứng dụng Microsoft Word, một luồng có thể chịu trách nhiệm kiểm tra chính tả và một luồng khác để chèn văn bản vào tài liệu.

### Sự khác biệt Process và Thread

- Các tiến trình thường độc lập, trong khi các luồng tồn tại dưới dạng tập hợp con của một tiến trình.
- Mỗi tiến trình có không gian bộ nhớ riêng. Các luồng thuộc cùng một tiến trình sẽ chia sẻ cùng một bộ nhớ. Vì vậy khi lập trình đa luồng thì cần lưu ý xử lý vấn đề xung đột bộ nhớ.
- Một tiến trình cần nhiều thời gian để tạo và chấm dứt(terminal).
- Chuyển đổi ngữ cảnh thì tốn kém hơn giữa các tiến trình.
- Giao tiếp giữa các luồng thì nhanh hơn.

  https://ant.ncc.asia/su-khac-biet-giua-process-va-thread-la-gi/

## Vòng đời của Thread

Khi một chương trình Java khởi chạy, JVM sẽ tạo ra một thread gọi là main thread, đây là nơi thực thi chương trình. Ngoài main thread, chúng ta có thể tạo thêm các thread khác tùy theo nhu cầu sử dụng.

### Các trạng thái vòng đời của Thread trong Java

- Một thread có các trạng thái sau:
  - NEW (Tạo Mới): Trạng thái khi thread mới được tạo, trước khi gọi start().
  - RUNNABLE (Đang Thực Thi): Thread sẵn sàng để chạy sau khi gọi start().
  - BLOCKED (Bị Chặn): Thread bị chặn khi cố gắng truy cập một đoạn mã đang được chiếm bởi thread khác hoặc khi chờ tài nguyên I/O.
  - WAITING (Chờ): Thread chờ vô thời hạn khi gọi wait() hoặc chờ với thời gian xác định khi gọi sleep().
  - TIMED_WAITING (Chờ Với Thời Gian Xác Định): Thread chờ với thời gian xác định khi gọi wait(timeout) hoặc sleep(timeout).
  - TERMINATED (Chấm Dứt): Thread kết thúc sau khi thực thi xong hoặc xảy ra ngoại lệ.
    ![alt text](image-9.png)

## Tạo Thread trong Java

- Có 2 cách:
  - Extend Thread class
  - Implement Runnable Interface

### Tạo Thread bằng cách thừa kế từ lớp Thread

- Tạo mới một lớp và kế thừa lớp này từ lớp cha Thread.
- Trong lớp mới tạo đó, override phương thức run().
- Cuối cùng, ở nơi khác, khi muốn tạo ra một Thread từ lớp này, khai báo đối tượng cho nó, rồi gọi đến phương thức start() của nó để bắt đầu khởi chạy Thread.

```
public class CountDownThread extends Thread {

    @Override
    public void run() {
        int count = 10;
        for (int i = count; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Hết giờ");
    }
}
```

```
public static void main(String[] args) {
    CountDownThread countDownThread = new CountDownThread();
    countDownThread.start();
}
```

### Tạo Thread bằng cách implement từ Interface Runnable

- Tạo mới một lớp và implement lớp này với interface có tên Runnable, override phương thức run()
- Khi muốn tạo ra một Thread từ lớp này, trước hết khai báo đối tượng cho nó, rồi khai báo thêm một đối tượng của Thread nữa và truyền đối tượng của lớp này vào hàm khởi tạo của Thread.
- Khi phương thức start() của lớp Thread vừa tạo được gọi đến, thì phương thức run() bên trong lớp dẫn xuất của Runnable sẽ được gọi để tạo thành một Luồng trong hệ thống.

```
public class CountDownThread implements Runnable {

    @Override
    public void run() {
        int count = 10;
        for (int i = count; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Hết giờ");
    }
}
```

```
public static void main(String[] args) {
    CountDownThread countDownThread = new CountDownThread();
    Thread thread = new Thread(countDownThread);
    thread.start();
}
```

## Trình lên lịch của Thread (Thread Scheduler)

### Thread Scheduler là gì?

- Trình lên lịch của Thread (Thread scheduler) trong java là một phần của JVM có nhiệm vụ quyết định thread nào nên được chạy.
- Chỉ có một thread tại một thời điểm có thể chạy trong một xử lý duy nhất.
- Thread scheduler chủ yếu sử dụng việc lập kế hoạch ưu tiên hoặc phân chia thời gian để lên lịch các luồng.

### Thread Scheduler hoạt động như nào?

- Có hai yếu tố để lên lịch cho một luồng tức là **Mức độ ưu tiên** và **Thời gian đến**.

  - **Mức độ ưu tiên:** mức độ ưu tiên của mỗi luồng nằm trong khoảng từ 1 đến 10. Nếu một luồng có mức độ ưu tiên cao hơn, điều đó có nghĩa là luồng đó có cơ hội tốt hơn được Trình lên lịch luồng chọn.
  - **Thời gian đến:** giả sử hai luồng có cùng mức độ ưu tiên nhập vào trạng thái chạy được, thì mức độ ưu tiên không thể là yếu tố để chọn một luồng từ hai luồng này. Trong trường hợp này, thời gian đến của luồng được xem xét bởi Trình lên lịch luồng. Một chủ đề đến trước sẽ được ưu tiên hơn các chủ đề khác.

- Ví dụ có các thread được thể hiện ở bảng dưới đây:

| Thread | Thời gian đến |
| ------ | ------------- |
| t1     | 0             |
| t2     | 1             |
| t3     | 2             |
| t4     | 3             |

Trong bảng trên, chúng ta có thể thấy rằng Luồng t1 đã đến đầu tiên, sau đó đến Luồng t2, rồi đến t3, và cuối cùng là t4, và thứ tự mà các luồng sẽ được xử lý là theo thời gian đến của các luồng.
![alt text](image-10.png)

Thông thường, thuật toán First Come First Serve là non-preemptive, điều này không tốt vì nó có thể dẫn đến bị block vô hạn. Để tránh điều đó chúng sẽ đc cắt ra thành các lát và được cung cấp cho các luồng một thời gian để sau một thời gian, luồng đang chạy phải ra khỏi CPU. Do đó, các luồng chờ khác cũng có thời gian để thực hiện công việc của họ.
![alt text](image-11.png)

Trong sơ đồ trên, mỗi luồng được đưa ra một lát thời gian là 2 giây. Vì vậy, sau 2 giây, luồng đầu tiên ra khỏi CPU, và sau đó CPU được bắt bởi Thread2. Quá trình tương tự cũng lặp lại cho các chủ đề khác.

![alt text](image-12.png)

Giả sử có nhiều luồng có sẵn ở trạng thái có thể chạy được. Trình lên lịch luồng chọn luồng có mức độ ưu tiên cao nhất. Vì thuật toán cũng có tính ưu tiên, do đó, các lát thời gian cũng được cung cấp cho các luồng để tránh bị starvation. Do đó, sau một thời gian, ngay cả khi luồng ưu tiên cao nhất chưa hoàn thành công việc của nó, nó vẫn phải giải phóng CPU vì quyền ưu tiên.
![alt text](image-13.png)

https://www.geeksforgeeks.org/preemptive-and-non-preemptive-scheduling/

## Thread Pool

![alt text](image-14.png)

- ThreadPool được dùng để giới hạn số lượng Thread được chạy bên trong ứng dụng của chúng ta trong cùng một thời điểm.

- Ví dụ: Khi chúng ta viết chương trình tải các tập tin từ Internet, mỗi tập tin cần 1 Thread để thực hiện quá trình tải, giả sử cần tải 100 tệp hình ảnh thì chúng ta phải cần tới 100 Thread hoạt động cùng một thời điểm trong cùng một chương trình. Điều này sẽ dễ dẫn đến lỗi quá tải của chương trình, làm ảnh hưởng đến hiệu suất và có thể dẫn đến gây lỗi (crash) chương trình.

- Vì vậy, thay vì tạo các luồng mới khi các task (nhiệm vụ) mới đến, một ThreadPool sẽ giữ một số luồng nhàn rỗi (no task) đã sẵn sàng để thực hiện tác vụ nếu cần. Sau khi một thread hoàn thành việc thực thi một tác vụ, nó sẽ không chết. Thay vào đó nó vẫn không hoạt động trong ThreadPool và chờ đợi được lựa chọn để thực hiện nhiệm vụ mới.

- Nếu tất cả các Thread đang bận rộn thực hiện nhiệm vụ, nhiệm vụ mới được đặt trong một hàng đợi (BlockingQueue), chờ đợi một Thread trở nên có sẵn.

- 1 vài loại ThreadPool:

## Excutor là gì?

- Một Executor là một đối tượng chịu trách nhiệm quản lý các luồng và thực hiện các tác vụ Runnable được yêu cầu xử lý. Nó tách riêng các chi tiết của việc tạo Thread, lập kế hoạch (scheduling), … để chúng ta có thể tập trung phát triển logic của tác vụ mà không quan tâm đến các chi tiết quản lý Thread.

- Java Concurrency API định nghĩa 3 interfaces cơ bản sau cho các Executor:

  - `Executor`: là interface cha của tất cả `Executor`. Nó xác định chỉ một phương thực `excute`(Runnable).
  - `ExecutorService`: là một Executor cho phép theo dõi tiến trình của các tác vụ trả về giá trị (Callable) thông qua đối tượng Future, và quản lý việc kết thúc các luồng. Các phương thức chính của nó bao gồm `submit`() và `shutdown`().
  - `ScheduledExecutorService`: là một `ExecutorService` có thể lên lịch cho các tác vụ để thực thi sau một khoảng thời gian nhất định, hoặc để thực hiện định kỳ. Các phương thức chính của nó là `schedule`(), `scheduleAtFixedRate`() and `scheduleWithFixedDelay`().

- Chúng có thể tạo một Executor bằng cách sử dụng một trong các phương thức được cung cấp bởi lớp tiện ích Executors như sau:
  - `newSingleThreadExecutor`(): trong ThreadPool chỉ có 1 Thread và các task (nhiệm vụ) sẽ được xử lý một cách tuần tự.
  - `newCachedThreadPool`(): trong ThreadPool sẽ có nhiều Thread và các nhiệm vụ sẽ được xử lý một cách song song. Các Thread cũ sau khi xử lý xong sẽ được sử dụng lại cho nhiệm vụ mới. Mặc định nếu một Thread không được sử dụng trong vòng 60 giây thì Thread đó sẽ bị tắt.
  - `newFixedThreadPool`(int n): trong ThreadPool sẽ được cố định các Thread. Nếu một nhiệm vụ mới được đưa vào mà các Thread đều đang “bận rộn” thì nhiệm vụ đó sẽ được gửi vào Blocking Queue và sau đó nếu có một Thread đã thực thi xong nhiệm vụ của nó thì nhiệm vụ đang ở trong Queue đó sẽ được push ra khỏi Queue và được Thread đó xử lý tiếp.
  - `newScheduledThreadPool`(int corePoolSize): tương tự như `newCachedThreadPool`() nhưng sẽ có thời gian delay giữa các Thread.
  - `newSingleThreadScheduledExecutor`(): tương tự như `newSingleThreadExecutor`() nhưng sẽ có khoảng thời gian delay giữa các Thread.
