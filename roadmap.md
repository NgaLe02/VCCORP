## BE Training

Tài liệu cho khóa train cơ bản cho thực tập parttime trong vòng 3 tháng

Các yêu cầu chung:

(1) sinh viên nhận task theo tuần để tự tự tìm hiểu.
(2) thắc mắc liên hệ người hướng dẫn, không quá 30p/ ngày.
(3) thực tập sinh liên hệ người hướng dẫn vào buổi cuối của mỗi tuần để review công việc (không quá 15 phút/ lần).
(4) xong sớm có thể báo review sớm và chuyển sang phần tiếp theo.
(5) trước khi review yêu cầu viết file report(các công việc đã làm, kết quả công việc, code nếu có, các khó khăn cần giải đáp) bằng markdown đẩy lên github cá nhân sau đó gửi trước cho người hướng dẫn, mỗi tuần là một file markdown.

### 1. Tuần 1

### 1.1. Yêu cầu (1): oop

- Mô tả: xây dựng chương trình java bất kì có xử dụng đầy đủ 4 tính chất của oop, 5 tính chất trong SOLID
- Tham khảo: http://www.w3resource.com/java-tutorial/java-object-oriented-programming.php
- Điều kiên hoàn thành: Từ chương trình đã xây dựng trình bày về đã áp dụng oop như nào, (2) hiểu các khái niệm interface, static, viết các biểu đồ UML liên quan

### 1.2. Yêu cầu (2) Đọc ghi file

- viết trương trình java đọc ghi file theo 2 dạng binary và text
- viết trương trình java thao tác với file và thư mục: list các file, đọc nội dung file

### 2. Tuần 2

### 2.1. Collection(s)

- Mô tả: viết trương trình java sử dụng các cấu trúc dữ liệu HashMap, HashSet, ArrayList
- Tham khảo (Overview) http://cs.lmu.edu/~ray/notes/collections/ (compare) http://www.codejava.net/java-core/collections/java-collections-framework-summary-table (performance) http://infotechgems.blogspot.com/2011/11/java-collections-performance-time.html
- Điều kiên hoàn thành: Cần nắm được HashMap,HashSet,ArrayList là gì, cách phương thức sử dụng ra sao, so sánh các đặc điểm. nắm được khái niệm hashcode, equals và lấy ví dụ minh họa sử dụng của hashcode, equal trong Set.

### 2.2. Design Pattern

- Đọc hiểu các Design Pattern cơ bản, lựa chọn ít nhất 3 Design Pattern (mỗi cái thuộc một trong các nhóm khởi tạo, hành vi và cấu trúc) để implement bằng java và trình bày lại. Cần vẽ các biểu đồ uml liên quan.

### 2.3. Serialize

- tìm hiểu liên quan serialize trong java. (viết code ví dụ minh họa bằng java và giải thích code) (phần này có chút liên quan tới trên cơ sở kiến thức từ 1.2, thực tập sinh có thể code liên hệ với code cũ)

### 3. Tuần 3

### 3.1. Exception

- nắm được cách xử lí exception, hệ thống các exception trong java, lấy ví dụ về ít nhất 2 loại exception(Checked Exception và Unchecked Exception) và cách fix nó.
- tham khảo: http://www.journaldev.com/1696/java-exception-handling-tutorial-with-examples-and-best-practices

### 3.2 Concurrency:

- Yêu cầu: (1) viết 1 luồng chạy ngầm kế thừa Runnable sử dụng java, (2) viết chương trình sử dụng threadpool bằng ngôn ngữ java
- tham khảo: http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
- tìm hiểu lock, atomic integer, concurrent hashmap, race condition, virtual thread(java 21)
- Seminar: thực tập sinh trong phần này cần làm silde thuyết trình về những tìm hiểu của mình và trình bày với team.
- deadlock, liveness, livelock, starvation
- schynonized: class
- lập trình luồng trong java: future
- concurenncy vs //
- thread daemon

### 3.3. json

- Yêu cầu: Dựa trên Serialize ở java tại mục 2.2, viết code có sử dụng json (yêu cầu có sử dụng maven)
- tham khảo: (1)https://www.tutorialspoint.com/json/json_overview.htm, (2) http://www.tutorialspoint.com/json/json_java_example.htm
- nắm được json là gì, sử dụng java parse json, lấy giá trị, chuyển jsonobject thành string
- sử dụng thư viện gson để parse trực tiếp 1 string sang 1 object tương ứng

### 4. tuần 4

- Yêu cầu (1): Tự cài đặt một cơ sở dữ liệu trên máy tính (cụ thể là mysql). trình bày chi tiết về các thành phần liên quan (vật lí - parser, optimizer, các loại storage engine, ...)
- Yêu cầu (2): Tự lấy ví dụ về 10 câu query mySQL không tốt và cách tối ưu nó (minh họa bằng explain).
- Yêu cầu (3): Tìm hiểu về các loại db và trình bày lại (ít nhất 3 db thuộc loại sql, 3 db thuộc loại no sql). các khái niệm CAP, BASE, ACID, 3 dạng chuẩn của csdl.

### 5. Tuần 5

- Yêu cầu tìm hiểu về Shell linux, các câu lệnh liên quan như:

```
- Các command cơ bản: cd, ls, cp, mv, mkdir,cat,head
- Các command liên quan đến quyền : chmod, chown, ls -l
- Các command thực hiện song song:
cat test.txt | wc -l
cat test.txt | grep "a"
cat test.txt | head
echo "aabb"  > test.txt
echo "cc" >> test.txt
- Sử dụng vim: tạo file mới, sửa file, save,vvv
- Quản lý tiến trình: htop, ps aux, kill -9

```

- Yêu cầu tìm hiểu về docker. Điều kiện hoàn thành: viết một chương trình sử dụng rest api cơ bản(GET /ping và response về "pong"). sau đó triển khai service trên docker sao cho đứng bên ngoài máy tính có thể call được service chạy trong docker.

### 6. Tuần 6

### 6.1 Tìm hiểu về Testing

- Unit Testing
- Func Testing
- Integration Test
- Load/stress test

### 6.2 Tìm hiểu về cache

- Tìm hiểu về redis
- Xây dựng một service sử dụng cache đo performace bằng stress test

### 7. Tuần 7-9

### 7.1 Tìm hiểu các pattarns

- Domain Driven Design
- CQRS & Event Sourcing

### 7.2 Tìm hiểu về ORMs & Transactions trong cơ sở dữ liệu

### 7.3 Tìm hiểu về message queue

- Kafka

### 7.4 Tìm hiểu về authentication

- JWT
- Basic Auth
- Token Auth

### 7.5 Dựng service

- Sử dụng một framwork thể hiện các vấn đề trên.

### 8. Tuần 10-12

- Tìm hiểu về logging
- Tìm hiểu GraphQL
- Tìm hiểu về cơ sở dữ liệu NoSQL: MongoDB
- Tìm hiểu về Search enginces: Elasticsearch/opensearch

---
