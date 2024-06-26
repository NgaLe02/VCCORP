1. Các công việc đã làm:

- Tìm hiểu 4 tính chất của OOP
- Tìm hiểu 5 tính chất của SOLID
- Xây dựng chương trình java áp dụng tính chất OOP
- Viết trương trình java đọc ghi file theo 2 dạng binary và text
- Viết trương trình java thao tác với file và thư mục: list các file, đọc nội dung file

2. Kết quả công việc:

2.1 4 tính chất của OOP:

- Tính trừu tượng (Abstraction )
  Ẩn các chi tiết hoặc quy trình bên trong khỏi người dùng. Điều này được thực hiện bằng cách tạo các class đại diện các đối tượng trong thế giới thực và các thuộc tính của chúng.

- Tính đóng gói (Encapsulation )
  Tính đóng gói cho phép che giấu thông tin và những tính chất xử lý bên trong của đối tượng. Các đối tượng khác không thể tác động trực tiếp đến dữ liệu bên trong và làm thay đổi trạng thái của đối tượng mà bắt buộc phải thông qua các phương thức công khai (method public) do đối tượng đó cung cấp.

  Tính chất này giúp tăng tính bảo mật cho đối tượng và tránh tình trạng dữ liệu bị hư hỏng ngoài ý muốn.

- Tính kế thừa (Inheritance)
  Khi một lớp kế thừa các phương thức và thuộc tính của một lớp khác
  Điều này giúp tái sự dung code và dễ dàng them các đặc điểm mới.

- Tính đa hình (Polymorphism)
  Cho phép tạo a các phương thức (method) với tên going nhau nhưng với các cách triển khai khác nhau.

  Điều này giúp tạo ra các hệ thống linh hoạt, dễ hiểu và dễ bảo trì hơn.

  2.2 5 tính chất của SOLID:

- Single Responsibility
  Một class chỉ nên chịu 1 trách nhiệm duy nhất.
- Open/Closed.
  Class chỉ nên mở cho việc mở rộng nhưng đóng cho việc chỉnh sửa (open for extension/ closed for modification)
  Có 1 ngoại lệ trong quy tắc này khi tồn tại bug trong code có sẵn.
- Liskov Substitution.
  Bất cứ instance nào của class cha cũng có thể được thay thế bởi instance của class con của nó mà không làm thay đổi tính đúng đắn của chương trình.
- Interface Segregation.
  Thay vì dùng 1 interface lớn, ta nên tách thành nhiều interface nhỏ, với nhiều mục đích cụ thể.
  Bằng cách đó, chúng ta có thể đảm bảo rằng các class chỉ cần quan tâm đến các phương thức (method) mà chúng quan tâm;

- Dependency Inversion.
  Các module cấp cao không phụ thuộc vào các module cấp thấp.
  Cả 2 nên phụ thuộc vào abstraction.
  Abstraction không nên phụ thuộc vào chi tiết mà ngược lại

  2.3 Khái niệm interface: là 1 lớp trừu tượng (abstract class) mà dùng để nhóm các phương thức (Method) liên quan với nhau mà không có logic.
  2.4 Từ khóa static:

  2.5 Trình bày đã áp dụng OOP trong chương trình đã xây dựng:

* Encapsulation: Các thuộc tính id, title, author, issueNumber được đóng gói trong các lớp.
* Inheritance: Book và Magazine kế thừa từ lớp LibraryItem.
* Polymorphism: Sử dụng phương thức displayInfo() đa hình.
* Abstraction: Lớp LibraryItem là lớp trừu tượng.
* SRP: Mỗi lớp chỉ có một trách nhiệm duy nhất.
* OCP: Lớp LibraryItem có thể mở rộng bằng cách thêm các lớp con mới mà không cần thay đổi lớp hiện tại.
* LSP: Các đối tượng -rrowable được tách riêng.
* DIP: LibrarySystem phụ thuộc vào abstraction là LibraryDatabase.

Code:
