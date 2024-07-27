## Khái niệm Log

- Log là một quá trình ghi lại những thông tin được thông báo, lưu lại trong quá trình hoạt động của một ứng dụng ở một nơi tập trung.

- Mục đích chính là để có thể xem lại các thông tin hoạt động của ứng dụng trong quá khứ như debug khi có lỗi xảy ra, xem info, error, warning,…

- Có nhiều cách để ghi log: có thể lưu vào file, console (sử dụng lệnh sysout), database hoặc đâu đó để có thể xem lại được.

## Phân loại log (Log Level)

- Log nên được phân loại tùy theo mục đích sử dụng, theo level:

  - `All`: đây là cấp độ thấp nhất, mọi thông tin cần log sẽ được log.
  - `Debug`: các thông tin dùng để debug.
  - `Info`: các thông tin mà bạn muốn ghi nhận thêm trong quá trình hoạt động của hệ thống.
  - `Warning`: log các thông tin cảnh báo của chương trình.
  - `Error`: các lỗi khi chạy chương trình sẽ được log.
  - `Fatal`: log các lỗi nghiêm trọng xảy ra trong chương trình, có thể làm cho chương trình không sử dụng được nữa.
  - `Off`: đây là cấp độ cao nhất, được sử dụng khi chúng ta không muốn log bất kỳ thông tin nào nữa.

- Độ ưu tiên của các cấp độ log từ thấp đến cao như sau:
  => ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF.

- Code demo:

## Refer

- [Log1](https://gpcoder.com/5500-gioi-thieu-java-logging/)
