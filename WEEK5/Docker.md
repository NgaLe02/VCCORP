## Docker là gì?

- Docker là một nền tảng mã nguồn mở giúp các nhà phát triển xây dựng, triển khai, chạy, cập nhật và quản lý các ứng dụng container hóa.
- Docker cho phép đóng gói ứng dụng và tất cả các phụ thuộc của nó vào một đơn vị tiêu chuẩn gọi là container, giúp ứng dụng có thể chạy một cách nhất quán trên nhiều môi trường khác nhau.

## Docker Engine là gì?

- **Docker engine** là một phần mền dạng “client-server” bao gồm các thành phần chính sau:
  - **Server** hay còn được gọi là **docker daemon (dockerd)**: chịu trách nhiệm tạo, quản lý các **Docker objects** như **images**, **containers**, **networks**, **volume**.
  - **REST API**: là nơi nhận các yêu cầu từ phía **Docker client** và giao tiếp với **Docker daemon** để yêu cầu **Docker daemon** thực thi các yêu cầu từ phía người dùng. -**Docker CLI** có vai trò là client, cung cấp giao diện tương tác với người dùng (command line) và gửi các request tương ứng đến Docker Daemon thông qua REST API. (Ví dụ docker images, docker ps, docker rmi image v.v..)
    ![alt text](image.png)

## Kiến trúc của Docker

- Docker sử dụng kiến trúc client – server.
- Docker server (hay còn gọi là daemon) sẽ chịu trách nhiệm build, run, distrubute Docker container
- Docker client và Docker server có thể nằm trên cùng một server hoặc khác server.
- Chúng giao tiếp với nhau thông qua REST API dựa trên UNIX sockets hoặc network interface.
  ![alt text](image-1.png)
  https://blog.cloud365.vn/container/tim-hieu-docker-phan-3/
  https://tel4vn.edu.vn/blog/gioi-thieu-tong-quan-ve-kien-truc-cua-docker/

## Các lệnh Docker cơ bản

- **docker --version**: Hiển thị phiên bản Docker hiện tại.

  ```
  docker --version
  ```

- **docker pull**: Kéo một Docker image từ Docker Hub.

```
docker pull <image_name>
```

- **docker run**: Tạo và chạy một container từ một Docker image.

```
docker run <image_name>
```

- **docker ps**: Liệt kê các container đang chạy.

```
docker ps
```

- **docker ps -a**: Liệt kê tất cả các container, bao gồm cả các container đã dừng.

```
docker ps -a
```

- **docker stop**: Dừng một container đang chạy.

```
docker stop <container_id>
```

- **docker start**: Khởi động lại một container đã dừng.

```
docker start <container_id>
```

- **docker rm**: Xóa một container đã dừng.

```
docker rm <container_id>
```

- **docker rmi**: Xóa một Docker image.

```
docker rmi <image_name>
```

https://kungfutech.edu.vn/bai-viet/docker/docker-la-gi
