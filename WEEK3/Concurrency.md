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
    https://ant.ncc.asia/su-khac-biet-giua-process-va-thread-la-gi/
