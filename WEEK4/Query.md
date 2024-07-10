Yêu cầu (2): Tự lấy ví dụ về 10 câu query mySQL không tốt và cách tối ưu nó (minh họa bằng explain).
Index
Explain
https://viblo.asia/p/toi-uu-hoa-co-so-du-lieu-va-tinh-chinh-cau-truy-van-trong-mysql-vyDZO3mOZwj

## Tối ưu hóa câu truy vấn

- **Sử dụng Index (Chỉ mục)**

Ví dụ: Tạo chỉ mục trên cột user_id trong bảng users để tăng tốc độ truy vấn khi lấy thông tin của một người dùng cụ thể.

```
CREATE INDEX idx_user_id ON users(user_id);
SELECT * FROM users WHERE user_id = 123;
```

- **Tránh sử dụng SELECT \***
  Việc sử dụng câu lệnh SELECT \* có thể làm chậm hiệu suất truy vấn vì nó trả về tất cả các cột trong một bảng, bao gồm cả những cột không cần thiết cho truy vấn. Để tối ưu hóa các truy vấn SQL, điều quan trọng là chỉ chọn các cột cần thiết cho truy vấn.
- **Sử dụng EXISTS thay vì IN**
  Một giá trị được so sánh với danh sách các giá trị được truy vấn con trả về bằng toán tử IN. Tuy nhiên, việc sử dụng IN có thể làm chậm hiệu suất truy vấn vì nó yêu cầu cơ sở dữ liệu thực hiện quét toàn bộ bảng trên truy vấn con. Để tối ưu hóa các truy vấn SQL, bạn có thể sử dụng toán tử EXISTS thay vì IN.

```
SELECT *
FROM users u
WHERE EXISTS (
    SELECT 1
    FROM orders o
    WHERE o.user_id = u.user_id
);
```

- **Tối ưu hóa JOIN và Subquery**

Sử dụng INNER JOIN thay vì subquery để kết nối dữ liệu từ các bảng khác nhau

- **Sử dụng LIMIT hoặc TOP, OFFSET để giới hạn số hàng trả về**

- **Hạn chế tối đa việc sử dụng ký tự đại diện**

  - Việc sử dụng các ký tự đại diện , chẳng hạn như % và \_, trong truy vấn SQL, có thể làm chậm hiệu suất truy vấn. Khi sử dụng ký tự đại diện, cơ sở dữ liệu phải quét toàn bộ bảng để tìm dữ liệu liên quan. Để tối ưu hóa các truy vấn SQL, điều quan trọng là giảm thiểu việc sử dụng các ký tự đại diện và chỉ sử dụng chúng khi thực sự cần thiết.

  - Ví dụ: hãy xem xét một truy vấn để xác định tất cả các khách hàng trong thành phố có họ bắt đầu bằng chữ cái “P”. Truy vấn sau đây sử dụng ký tự đại diện để tìm tất cả các record khớp với yêu cầu:

    ```
    SELECT * FROM customers WHERE last_name_city LIKE 'P%';
    ```

    Truy vấn vẫn sẽ hoạt động nhưng sẽ chậm hơn khi sử dụng index trên cột Last_name_city. Truy vấn có thể được cải thiện bằng cách thêm index vào cột Last_name_city và viết lại như sau:

    ```
    SELECT * FROM customers WHERE last_name_city >= 'P' AND last_name < 'Q';
    ```
