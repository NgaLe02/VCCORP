### 7.2 Tìm hiểu về ORMs & Transactions trong cơ sở dữ liệu

## ORMs

## Transactions

### Vấn đề đọc ghi dữ liệu của 1 row khi nó dính đễn transaction

- `Read uncommited`: Khi transaction thực hiện ở mức này, các truy vấn vẫn có thể truy nhập vào các bản ghi đang được cập nhật bởi một transaction khác và nhận được dữ liệu tại thời điểm đó mặc dù dữ liệu đó chưa được commit (uncommited data) => dirty read

  - Ví dụ:
    Transaction A đọc một giá trị từ cơ sở dữ liệu.
    Transaction B sửa đổi giá trị đó và chưa commit.
    Transaction A có thể đọc giá trị đã được sửa đổi bởi transaction B, mặc dù transaction B chưa được hoàn tất.

- `Read committed`: Transaction sẽ không đọc được dữ liệu đang được cập nhật mà phải đợi đến khi việc cập nhật thực hiện xong => phantom read

  - Ví dụ:
    Transaction A đọc một giá trị từ cơ sở dữ liệu.
    Transaction B sửa đổi giá trị đó và commit.
    Transaction A chỉ có thể đọc giá trị đã được sửa đổi bởi transaction B sau khi transaction B được cam kết.

- `Repeatable read`: Giao dịch hiện tại sẽ không nhìn thấy các thay đổi được thực hiện bởi các giao dịch khác chưa được commit

  - Ví dụ:
    Transaction A đọc một tập dữ liệu.
    Transaction B sửa đổi giá trị đó và commit.
    Transaction A không thể nhìn thấy sự thay đổi do transaction B thực hiện và vẫn đọc được tập dữ liệu ban đầu.

- `Serializable`: SQL đặt read + write lock trên dữ liệu cho tới khi transaction kết thúc.

  - Ví dụ:
    Transaction A và B truy cập cùng một hàng dữ liệu.
    Chỉ có một transaction có thể truy cập hàng dữ liệu tại một thời điểm, giống như trong hàng đợi.

- Refer: [T1](https://gitiho.com/blog/huong-dan-cac-kieu-cua-lenh-join-trong-mysql-inner-outer-left-right-cross.html)
  [T2](https://viblo.asia/p/dao-sau-ve-sql-transactions-E375z4jWZGW)
  [t3](https://www.youtube.com/watch?v=WKGIz5ViT7Y&t=391s)
