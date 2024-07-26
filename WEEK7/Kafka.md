## Khái niệm

- Apache Kafka là một nền tảng mã nguồn mở, phân tán được sử dụng để xử lý luồng dữ liệu thời gian thực.

- Kafka được tạo ra để giải quyết những thách thức trong việc xử lý lượng dữ liệu khổng lồ trong thời gian thực (real-time), cho phép các ứng dụng xuất bản (publish), đăng ký (subscribe), lưu trữ (store) và xử lý (process) các luồng bản ghi (streaming event) một cách hiệu quả.

## Thành phần

![alt text](image-7.png)

### 1. Kafka Event

- Kafka Event hay còn gọi là message hoặc record là đơn vị cơ bản được gửi và nhận trong hệ thống Kafka. Đây là một bản ghi dữ liệu chứa thông tin về một sự kiện nào đó đã xảy ra

- Mỗi event chứa một key (khoá), value (giá trị) và metadata (nếu có).

```
{
	key: "Violet",
	value: "Made a payment of $100 to Alex",
	timestamp: "Jun. 25, 2023, at 2:06 p.m."
}
```

### 2. Kafka Topic

- Các event được tổ chức và lưu trữ lâu dài trong các topics (chủ đề).
- Các producer gửi message đến một topic cụ thể và các consumer đăng ký vào các topic để nhận message.
  ![alt text](image-8.png)

### 3. Kafka Brokers và Kafka Clusters

## Refer

https://www.youtube.com/watch?v=HGywc-e5f4E&list=PLsfLgp1K1xQ42CWP8dsIa7OT2EJFnRGGd
https://topdev.vn/blog/kafka-la-gi/
https://200lab.io/blog/kafka-la-gi/

bin\windows\zookeeper-server-start.bat config\zookeeper.properties
bin\windows\kafka-server-start.bat config\server.properties
