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

  ![alt text](image-1.png)

  https://minervadb.xyz/what-is-a-parse-call-in-mysql/
  https://medium.com/coderbyte/understanding-mysql-logical-architecture-526eaf72f66e
  https://www.youtube.com/watch?v=aKOaQfpW7to

## Optimizer

## Storage engine

### MyISAM engine

### InnoDB engine

### Other Built-In Engines

#### Memory engine

#### Archive engine

#### CSV engine

#### Falcon engine

#### Maria engine (Cơ sở dữ liệu liên quan: MariaDB)

https://rivercrane.vn/blog/technical/gioi-thieu-mot-so-storage-engine-cua-mysql-1055/
https://viblo.asia/p/toi-uu-hoa-co-so-du-lieu-va-tinh-chinh-cau-truy-van-trong-mysql-vyDZO3mOZwj

how to query cache in mysql work
https://www.youtube.com/results?search_query=how+to+query+cache+in+mysql+work
