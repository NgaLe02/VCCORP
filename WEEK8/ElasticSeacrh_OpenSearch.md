## Khái niệm

- ElasticSearch là một công cụ tìm kiếm dựa trên nền tảng Apache Lucene, được phát triển bằng Java. Nó cung cấp một bộ máy tìm kiếm dạng phân tán, có đầy đủ công cụ với một giao diện web HTTP có hỗ trợ dữ liệu JSON.

- Elasticsearch thực chất hoặt động như 1 web server, có khả năng tìm kiếm nhanh chóng (near realtime) thông qua giao thức RESTful

- Elasticsearch có khả năng phân tích và thống kê dữ liệu

## Hoạt động

![alt text](image-2.png)

- ES sẽ chạy một cổng (dưới local default là 9200).

## Các khái niệm cần biết

![alt text](image-3.png)

### 1. Document

- Document là một JSON object với một số dữ liệu
- Ví dụ: Trong một index chứa thông tin người dùng, mỗi người dùng sẽ được biểu diễn bằng một document.

### 2. Index

- Sử dụng một cấu trúc được gọi là [inverted index](https://en.wikipedia.org/wiki/Inverted_index?ref=200lab.io).

- Ví dụ: Chúng ta có 2 văn bản cụ thể như sau :

```
1,The quick brown fox jumped over the lazy dog
2,Quick brown foxes leap over lazy dogs in summer
```

Inverted index tương ứng:
| Term | Doc_1 | Doc_2 |
|---------|-------|-------|
| Quick | | X |
| The | X | |
| brown | X | X |
| dog | X | |
| dogs | | X |
| fox | X | |
| foxes | | X |
| in | | X |
| jumped | X | |
| lazy | X | X |
| leap | | X |
| over | X | X |
| quick | X | |
| summer | | X |
| the | X | |
