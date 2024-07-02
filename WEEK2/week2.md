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

D đại diện cho "Duplicates" (trùng lặp).
O đại diện cho "Ordering" (thứ tự).
E đại diện cho "Efficient Index-Based Access" (truy cập dựa trên chỉ mục hiệu quả).
TS đại diện cho "Thread Safe" (an toàn luồng).

https://topdev.vn/blog/noi-ve-serialization-trong-java/
https://viblo.asia/p/java-serialization-XL6lAYrDlek
https://www.javatpoint.com/design-patterns-in-java
https://chatgpt.com/c/79496a9e-d595-4795-8635-f0f8289bc6ba

https://www.plantuml.com/plantuml/uml/SyfFKj2rKt3CoKnELR1Io4ZDoSa70000

https://www.javatpoint.com/exception-handling-in-java
