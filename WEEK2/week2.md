1. Tìm hiểu tổng quan về Collection

- Collection là 1 đối tượng chứa một nhóm đối tượng

- Collection có 1 số interface sau:
  | Interface | Implementation Classes |
  |-----------|------------------------------------------------------------------|
  | Set | HashSet, LinkedHashSet, EnumSet, CopyOnWriteArraySet |
  | List | ArrayList, LinkedList, CopyOnWriteArrayList |
  | Map | HashMap, LinkedHashMap, EnumMap, IdentityHashMap, WeakHashMap |

2. So sánh
   | Main Collection Classes | D | O | E | TS |
   |-------------------------|-----|-----|-----|-----|
   | HashSet | No | No | No | No |
   | ArrayList | Yes | Yes | No | No |
   | HashMap | No | No | No | No |

Trong bảng này:

- D đại diện cho "Duplicates" (trùng lặp).
- O đại diện cho "Ordering" (thứ tự).
- E đại diện cho "Efficient Index-Based Access" (truy cập dựa trên chỉ mục hiệu quả).
- TS đại diện cho "Thread Safe" (an toàn luồng).

3. HashMap

- HashMap là một cấu trúc dữ liệu ánh xạ các khóa tới các giá trị. Nó lưu trữ dữ liệu theo cặp khóa-giá trị và không cho phép các khóa trùng lặp.

- Phương thức chính của HashMap:

put(K key, V value): Thêm một cặp khóa-giá trị vào HashMap.
get(Object key): Trả về giá trị liên kết với khóa được chỉ định.
containsKey(Object key): Kiểm tra xem HashMap có chứa khóa được chỉ định không.
remove(Object key): Xóa mục với khóa được chỉ định khỏi HashMap.

4. HashSet

- HashSet là một tập hợp không chứa các phần tử trùng lặp. Nó sử dụng HashMap nội bộ để lưu trữ các phần tử.

- Phương thức chính của HashSet:

add(E e): Thêm một phần tử vào HashSet.
contains(Object o): Kiểm tra xem HashSet có chứa phần tử được chỉ định không.
remove(Object o): Xóa phần tử khỏi HashSet. 5. ArrayList

- ArrayList là một mảng động, cho phép lưu trữ các phần tử theo thứ tự chèn vào và có thể thay đổi kích thước động.

- Phương thức chính của ArrayList:

add(E e): Thêm một phần tử vào cuối ArrayList.
get(int index): Trả về phần tử tại vị trí chỉ định.
remove(int index): Xóa phần tử tại vị trí chỉ định.
size(): Trả về số lượng phần tử trong ArrayList.

- https://topdev.vn/blog/noi-ve-serialization-trong-java/
  https://viblo.asia/p/java-serialization-XL6lAYrDlek
  https://www.javatpoint.com/design-patterns-in-java
  https://chatgpt.com/c/79496a9e-d595-4795-8635-f0f8289bc6ba

https://www.plantuml.com/plantuml/uml/SyfFKj2rKt3CoKnELR1Io4ZDoSa70000

https://www.javatpoint.com/exception-handling-in-java
