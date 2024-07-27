## Khái niệm

- GraphQL là ngôn ngữ dùng để thao tác và truy vấn dữ liệu cho API, cung cấp cho client 1 cách thức dễ dàng để request **chính xác những gì họ cần**.

- GraphQL điều hướng các resources con trong một request duy nhất và cũng cho phép thực hiện nhiều truy vấn trong một request.

- Ví dụ:

```
query {
    recentPosts(count: 10, offset: 0) {
        id
        title
        category
        author {
            id
            name
            thumbnail
        }
    }
}

```

- Những truy vấn này sẽ:
  - Yêu cầu 10 bài post gần đây nhất
  - Với mỗi bài post, yêu cầu ID, title và category
  - Với mỗi post, yêu cầu tác giả, trả về ID, tên và ảnh thumbnail
- Với REST API truyền thống, nó sẽ cần 11 request, 1 cho bài post và 10 cho tác giả hoặc là cần nhúng data của tác giả vào data của post.

## Schema GraphQL là gì?

- Schema GraphQL là một bản mô tả chi tiết về cấu trúc dữ liệu mà một API GraphQL có thể cung cấp. Nó giống như một bản thiết kế, xác định rõ các loại đối tượng, các trường có thể truy vấn và mối quan hệ giữa chúng.

- Code:

## Refe:

- [GraphQL1](https://viblo.asia/p/bat-dau-voi-graphql-va-spring-boot-Az45byWolxY)
