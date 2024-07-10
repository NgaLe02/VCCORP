Yêu cầu (1): Tự cài đặt một cơ sở dữ liệu trên máy tính (cụ thể là mysql). trình bày chi tiết về các thành phần liên quan (vật lí - parser, optimizer, các loại storage engine, ...)

Kiến trúc logic của **MySQL** nhìn tổng quan có thể được mô tả như hình dưới đây:

![alt text](image.png)

Ta có thể thấy MySQL có các component cơ bản như ở dưới đây:

- Connection/thread handling.
  - Query cache.
  - Parser.
  - Optimizer.
  - Storage engine.

## Query cache

- `Query Cache` là một tính năng cho phép lưu trữ kết quả của các câu lệnh `SELECT` vào bộ nhớ cache, để các câu lệnh `SELECT` có cùng cấu trúc và các tham số truy vấn tương tự có thể được trả về từ bộ nhớ cache mà không cần thực thi lại câu lệnh truy vấn đến cơ sở dữ liệu.
  => Điều này giúp cải thiện hiệu suất của hệ thống bằng cách giảm thời gian xử lý và tải cho cơ sở dữ liệu.

- Kể từ MySQL 8.0, tính năng query cache đã bị loại bỏ.

  https://hocvps.com/toi-uu-mysql-query-cache/
  https://www.digitalocean.com/community/tutorials/how-to-optimize-mysql-with-query-cache-on-ubuntu-18-04
  https://dev.mysql.com/doc/refman/5.7/en/query-cache-operation.html

## Parser (Phân tích cú pháp)

- `Phân tích cú pháp` (`parse`) trong MySQL đề cập đến quá trình phân tích một câu lệnh SQL và chuẩn bị nó cho việc thực thi.

- `Phân tích cú pháp` (`parse`) được thực hiện bởi bộ phân tích cú pháp MySQL, có trách nhiệm _xác minh cú pháp của câu lệnh SQL_, _kiểm tra các quyền của người dùng đã gửi câu lệnh_, và _xác định kế hoạch thực thi tốt nhất cho câu lệnh_

- MySQL phân tích cú pháp các truy vấn để tạo cấu trúc bên trong (`Parser tree`).

- Quá trình `parse`:

  - Lexical Analysis (Phân tích từ vựng): Chia câu lệnh SQL thành các token (như từ khóa, tên bảng, tên cột, giá trị, v.v.).
  - Syntax Analysis (Phân tích cú pháp): Kiểm tra cấu trúc của câu lệnh để đảm bảo rằng nó tuân theo các quy tắc cú pháp của SQL.
  - Semantic Analysis (Phân tích ngữ nghĩa): Đảm bảo rằng các đối tượng được tham chiếu (như bảng và cột) tồn tại và có thể sử dụng trong ngữ cảnh đó.

- Ví dụ:

```
SELECT id, name FROM t_user WHERE status = 'ACTIVE' AND age > 18
```

![alt text](image-1.png)

https://minervadb.xyz/what-is-a-parse-call-in-mysql/
https://medium.com/coderbyte/understanding-mysql-logical-architecture-526eaf72f66e
https://www.youtube.com/watch?v=aKOaQfpW7to

## Optimizer

- Sau khi tạo `Parser tree` nội bộ, MySQL áp dụng nhiều kỹ thuật tối ưu hóa khác nhau. Các kỹ thuật này có thể bao gồm, _viết lại truy vấn_, _thứ tự quét các bảng_ và _chọn các index phù hợp_ ... để sử dụng.
  => Trên thực tế, bạn có thể yêu cầu máy chủ giải thích các khía cạnh khác nhau của việc tối ưu hóa.
- Ví dụ:

```
EXPLAIN SELECT * FROM users;
```

## Storage engine (Công cụ lưu trữ)

- Có nhiều loại storage engine khác nhau cho các tình huống và yêu cầu khác nhau.

- Mục đích:
  - Duy trì cơ sở dữ liệu
  - Lấy dữ liệu
  - Một chỉ mục (index) cung cấp quyền truy cập vào dữ liệu

### InnoDB engine

- InnoDB là storage engine mặc định trong mysql.
- Các đặc điểm:

  - **Hỗ trợ ACID**: InnoDB hỗ trợ các tính chất ACID (Atomicity, Consistency, Isolation, Durability), làm cho nó rất phù hợp cho các ứng dụng đòi hỏi tính toàn vẹn dữ liệu và quản lý giao dịch hiệu quả.

  - **Khóa cấp hàng (Row-Level Locking)**: InnoDB sử dụng khóa cấp hàng thay vì khóa toàn bộ bảng, cho phép nhiều giao dịch cùng thời điểm thực hiện trên cùng một bảng mà không gây ra xung đột.

  - **Ràng buộc khóa ngoại (Foreign Key Constraints)**: InnoDB hỗ trợ ràng buộc khóa ngoại, cho phép xác định và duy trì các mối quan hệ giữa các bảng

  - **Hỗ trợ transaction:** InnoDB cho phép commit (hoàn thành) và rollback (hủy) các giao dịch, đảm bảo tính nhất quán và toàn vẹn dữ liệu trong trường hợp giao dịch thất bại hoặc có sự cố.

  - **Khôi phục sau sự cố (Crash Recovery)**: InnoDB có khả năng tự động phục hồi dữ liệu sau khi xảy ra sự cố như mất điện, đảm bảo dữ liệu không bị mất.

  - **Đa phiên (Multi-Version Concurrency Control - MVCC)**: InnoDB sử dụng MVCC để đảm bảo tính độc lập (Isolation) của các giao dịch, cho phép đọc và ghi đồng thời mà không xảy ra xung đột.

- InnoDB lưu dữ liệu trên 1 file (thuật ngữ gọi là tablespace).

### MyISAM engine

- Các đặc điểm:

  - **Không hỗ trợ transactions.**
  - **Không hỗ trợ row-level lock.**
  - **Full-text index**: MyISAM có thể đánh chỉ mục full-text, hỗ trợ tìm kiếm full-text.
  - **Compression**: MyISAM hỗ trợ nén dữ liệu, hỗ trợ tăng tốc độ đọc dữ liệu. Mặc dù vậy dữ liệu sau khi nén không thể cập nhật được.
  - **Khôi phục sau sự cố (crash recovery)**: MyISAM có khả năng tự sửa chữa và phục hồi dữ liệu sau khi hệ thống crashed.
  - MyISAM không ghi dữ liệu ngay vào ổ đĩa cứng, mà ghi vào 1 buffer trên memory (và chỉ ghi vào đĩa cứng sau 1 khoảng thời gian), do đó tăng tốc độ ghi.
  - Hỗ trợ các kiểu dữ liệu không gian và các chức năng hệ thống thông tin địa lý (GIS).

- MyISAM lưu mỗi bảng dữ liệu trên 2 file: .MYD cho dữ liệu và .MYI cho chỉ mục. Row có 2 loại: dynamic và static (tuỳ thuộc bạn có dữ liệu thay đổi độ dài hay không). Số lượng row tối đa có thể lưu trữ bị giới hạn bởi hệ điều hành, dung lượng đĩa cứng. MyISAM mặc định sử dụng con trỏ độ dài 6 bytes để trỏ tới bản ghi dữ liệu, do vậy giới hạn kích thước dữ liệu xuống 256TB.

### Other Built-In Engines

#### Memory engine

- Còn được gọi là HEAP tables.

- Sau khi server restart, cấu trúc bảng được bảo toàn, dữ liệu bị mất hết.
- Memory engine sử dụng HASH index nên rất nhanh cho query lookup.
- Memory engine dùng table-level locking do vậy tính concurrency không cao.

- Không hỗ trợ các loại cột TEXT hoặc BLOB, chỉ lưu trữ dòng dữ liệu dưới dạng có kích thước cố định, có nghĩa là các cột VARCHAR sẽ được lưu trữ như CHAR.
  => Điều này có thể dẫn đến lãng phí bộ nhớ nếu các cột VARCHAR có độ dài khác nhau.

#### Archive engine

- Chỉ hỗ trợ Insert và Select.
- Không đánh chỉ mục.
- Dữ liệu được buffer và nén bằng zlib nên tốn ít I/O, tốc độ ghi do đó cao.
- Tốc độ ghi cao, phù hợp cho ứng dụng log.

#### CSV engine

- Coi file CSV như là 1 table.
- Không hỗ trợ đánh chỉ mục.
- Nếu bài toán là trích xuất thông tin từ file CSV và ghi vào cơ sở dữ liệu, đồng thời cần kết quả CSV ngay từ DB, engine này có vẻ thích hợp.

https://rivercrane.vn/blog/technical/gioi-thieu-mot-so-storage-engine-cua-mysql-1055/
https://www.youtube.com/results?search_query=how+to+query+cache+in+mysql+work
