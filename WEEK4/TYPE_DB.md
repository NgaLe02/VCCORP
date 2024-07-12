Yêu cầu (3): Tìm hiểu về các loại db và trình bày lại (ít nhất 3 db thuộc loại sql, 3 db thuộc loại no sql). các khái niệm CAP, BASE, ACID, 3 dạng chuẩn của csdl.

## CAP

## BASE

## ACID

- `ACID` là một thuật ngữ được sử dụng trong cơ sở dữ liệu để mô tả các tính chất cần thiết để đảm bảo tính toàn vẹn của giao dịch. Đây là một viết tắt cho các từ khóa sau đây:

  - `Atomicity` (Tính nguyên tử): Giao dịch được coi là hoàn thành hoặc không hoàn thành toàn bộ. Điều này có nghĩa là nếu _một phần của giao dịch thất bại, toàn bộ giao dịch sẽ bị hủy và không có thay đổi nào được áp dụng vào cơ sở dữ liệu_.

  - `Consistency` (Tính nhất quán): Cơ sở dữ liệu phải ở trạng thái hợp lý trước và sau khi giao dịch được thực thi. Điều này đảm bảo rằng dữ liệu không bị vi phạm các ràng buộc quyền lực, quan hệ hay ràng buộc ngữ nghĩa.

  - `Isolation` (Tính độc lập): Mỗi giao dịch được thực hiện độc lập với các giao dịch khác, điều này ngăn chặn các thay đổi không mong muốn xảy ra khi nhiều giao dịch đang thực hiện đồng thời. Isolation đảm bảo tính nhất quán của cơ sở dữ liệu trong khi nhiều giao dịch đang diễn ra.

  - `Durability` (Tính bền vững): Sau khi giao dịch được thực hiện và giao dịch được xác nhận thành công, các thay đổi được áp dụng vào cơ sở dữ liệu sẽ không bị mất do lỗi hệ thống hay lỗi phần cứng. Dữ liệu đã được lưu trữ sẽ được bảo vệ và khôi phục khi cần thiết.

Các tính chất này cùng nhau tạo nên ACID để đảm bảo tính toàn vẹn và nhất quán của dữ liệu trong các hệ thống cơ sở dữ liệu. Các hệ thống quản lý cơ sở dữ liệu (DBMS) như MySQL cung cấp hỗ trợ ACID bằng cách triển khai các giải pháp và thuật toán phù hợp để đảm bảo các tính chất này cho các giao dịch dữ liệu.

## 3 dạng chuẩn của CSDL

- **Mục đích** :

  - Chuẩn hóa dữ liệu là quá trình biểu diễn cơ sở dữ liệu dưới dạng chuẩn. Đây là một kỹ thuật thiết kế bảng trong cơ sở dữ liệu, chia các bảng lớn thành các bảng nhỏ hơn và liên kết chúng bằng các mối quan hệ.
  -

- **Các dạng**:
  Có 4 dạng chuẩn hóa chính để xử lý cơ sở dữ liệu:

  - Dạng chuẩn 1(1NF)
  - Dạng chuẩn 2(2NF)
  - Dạng chuẩn 3(3NF)
  - Chuẩn Boyce-Codd(BCNF)

![alt text](image-12.png)

- **Các khái niệm cơ bản**:

  - Phụ thuộc hàm
    - Trong một quan hệ, nếu giá trị của bộ thuộc tính A có thể suy ra được nếu biết giá trị của bộ thuộc tính B thì ta nói A phụ thuộc hàm vào B
    - VD: HocSinh(MaHS, TenHS, NgaySinh)
      TenHS và NgaySinh đều là những thuộc tính phụ thuộc hàm vào MaHS
  - Phụ thuộc đầy đủ, phụ thuộc bộ phận
    Trong một quan hệ, bộ thuộc tính A phụ thuộc hàm vào bộ thuộc tính B. Nếu loại bỏ một thuộc tính bất kì trong bộ thuộc tính B mà A vẫn phụ thuộc hàm vào B thì A được gọi là phụ thuộc hàm đầy đủ vào B. Ngược lại, A được gọi là phụ thuộc bộ phận vào B.
  - Phụ thuộc bắc cầu
    Trong một quan hệ, nếu thuộc tính A phụ thuộc hàm vào thuộc tính B, thuộc tính B phụ thuộc hàm vào thuộc tính C thì thuộc tính A được gọi là phụ thuộc bắc cầu vào thuộc tính C thông qua thuộc tính B.

### Dạng chuẩn 1 (1NF)

- Một quan hệ gọi là 1NF nếu
  - Miền giá trị của mỗi thuộc tính chỉ chứa giá trị đơn nguyên tử, không thể phân tách ra được
  - Giá trị của mỗi thuộc tính trong mỗi bộ phải là giá trị đơn
    https://viblo.asia/p/tong-hop-ve-chuan-hoa-co-so-du-lieu-ORNZqP33K0n
- CHuẩn hóa:

  - Tách các thuộc tính có miền giá trị đa nguyên tử thành các thuộc tính có miền giá trị đơn nguyên tử
    - VD: HOCSINH(MaHS, Tuoi, HoTen)
      Thuộc tính HoTen trong bảng trên là một thuộc tính chứa giá trị đa nguyên tử. HoTen bao gồm Họ và Tên.
      HOCSINH(MaHS, Tuoi, Ho, Ten)
  - Tách các thuộc tính chứa giá trị đa trị ra thành một bảng riêng

            - Ví dụ:
              NhanVien_ChucVu(MaNV, MaChucVu, ThoiGianNhanChuc)

              | MaNV | MaChucVu | ThoiGianNhanChuc |
              | ---- | -------- | ---------------- |
              | 1    | 2 3       | 15-8-2019 16-8-2019 |

              |MaChucVu | TenChucVu |
              | ---- | -------|
              |3 | GiamDoc |
              |2 | BaoVe |

              NhanVien_ChucVu(MaNV, MaChucVu, ThoiGianNhanChuc)

              | MaNV | MaChucVu | ThoiGianNhanChuc |
              |------|----------|------------------|
              | 1    | 2        | 15-8-2019        |
              | 1    | 3        | 16-8-2019        |

    https://funix.edu.vn/chia-se-kien-thuc/chuan-hoa-cac-quan-he-ve-cac-dang-chuan-co-ban/  
     https://viblo.asia/p/cac-chuan-trong-co-so-du-lieu-va-cac-buoc-chuan-hoa-bWrZnEBpKxw
