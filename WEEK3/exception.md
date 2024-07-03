## Exception

- Trong java, Exception là một sự kiện làm gián đoạn luồng bình thường của chương trình. Nó là một đối tượng được ném ra tại runtime.

## Lợi ích

- Việc xử lý ngoại lệ giúp duy trì luồng bình thường của ứng dụng.

## Hệ thống các lớp ngoại lệ trong Java

![alt text](image.png)

## Các kiểu ngoại lệ

![alt text](image-1.png)

- Checked Exception:
  - Là một ngoại lệ được kiểm tra và thông báo bởi trình biên dịch tại thời điểm biên dịch, chúng cũng có thể được gọi là ngoại lệ thời gian biên dịch (Compile-time Exceptions).
  - Ví dụ: Bạn muốn mở một file để đọc nhưng tệp được chỉ định lại không tồn tại. Thì FileNotFoundExeption sẻ xảy ra và trình biên dịch sẽ thông báo tới lập trình viên nhằm xử lý ngoại lệ đó.
- Unchecked Exception:
  - Là một ngoại lệ không được kiểm tra trong quá trình biên dịch, chỉ xảy ra ở runtime.
  - Unchecked Exceptions kế thừa từ Runtime Exception.
  - Ví dujL ArithmaticException, ArrayIndexOutOfBoundsException, NullPointerException,…chúng được kiểm tra tại Runtime.

## Xử lý ngoại lệ (Exeption Handling)

- Exception Handling (xử lý ngoại lệ) là một cơ chế xử lý các lỗi runtime như ClassNotFound, IO, SQL, Remote

![alt text](image-2.png)

- Exception Handling được thực hiện bằng try/catch block.

![alt text](image-3.png)

- Nếu trong try block xảy ra Exception, code trong try sẽ không được thực thi nữa. JVM sẽ tìm kiếm catch block có xử lý Exception đó.
- Nếu không có catch block hay catch block không xử lý đúng Exception bị throw, code thực thi finally block và ngắt Thread hiện tại.
- Nếu catch block xử lý đúng Exception, code tiếp tục thực thi đến khi hết catch, sau đó finally thực thi Thread như thông thường.
