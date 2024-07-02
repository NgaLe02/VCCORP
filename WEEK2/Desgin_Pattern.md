## Các design pattern cơ bản:

- Creational Patterns (Nhóm khởi tạo): Tạo các đối tượng một cách linh hoạt và hiệu quả.
  gồm có:
  - Factory Pattern
  - Abstract Factory Pattern
  - Singleton Pattern
  - Prototype Pattern
  - Builder Pattern
- Structural Patterns (Nhóm cấu trúc): Tổ chức các đối tượng và lớp để hình thành các cấu trúc lớn hơn.
  gồm có:
  - Adapter Pattern
  - Bridge Pattern
  - Composite Pattern
  - Decorator Pattern
  - Facade Pattern
  - Flyweight Pattern
  - Proxy Pattern
- Behavioral Patterns (Nhóm hành vi): Định nghĩa cách các đối tượng tương tác và phân chia trách nhiệm.
  gồm có:
  - Chain Of Responsibility Pattern
  - Command Pattern
  - Interpreter Pattern
  - Iterator Pattern
  - Mediator Pattern
  - Memento Pattern
  - Observer Pattern
  - State Pattern
  - Strategy Pattern
  - Template Pattern
  - Visitor Pattern

  ## Singletion Pattern 
  - Sử dụng để đảm bảo rằng một lớp chỉ có duy nhất một đối tượng (instance) và cung cấp một cách để truy cập global đến thể hiện đó.

  - Thường được sử dụng khi bạn muốn có một thực thể duy nhất để quản lý tài nguyên chung hoặc cấu hình toàn cục trong ứng dụng của mình.

  - Đặc điểm của Singleton Pattern:
    - Constructor private: Để ngăn chặn việc khởi tạo đối tượng từ bên ngoài lớp.
    - Biến static private instance: Lưu trữ tham chiếu tới thực thể duy nhất của lớp.
    - Phương thức static public getInstance(): Cung cấp cách truy cập đến thực thể Singleton.

  - Lợi ích của Singleton Pattern:
    - Đảm bảo duy nhất: Một lớp chỉ có một thực thể duy nhất, giúp tiết kiệm tài nguyên và duy trì tính nhất quán.
    - Tiện dụng trong quản lý tài nguyên toàn cục: Ví dụ như đối tượng kết nối đến cơ sở dữ liệu, ghi log, cấu hình ứng dụng, ...
    - Thiết kế linh hoạt: Dễ dàng thay đổi từ việc sử dụng nhiều thực thể đến duy nhất.

`
public class Singleton {
    private static Singleton instance;
    
    // private constructor để ngăn chặn việc khởi tạo từ bên ngoài
    private Singleton() {
    }
    
    // phương thức static để lấy instance duy nhất của Singleton
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    // các phương thức và thuộc tính khác của Singleton
}`

  ## Adapter Pattern


https://chatgpt.com/c/5dcb8815-58c4-458a-9b3b-006788bbc0a4
