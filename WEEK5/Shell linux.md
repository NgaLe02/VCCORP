
```
- Các command cơ bản: cd, ls, cp, mv, mkdir,cat,head
- Các command liên quan đến quyền : chmod, chown, ls -l
- Các command thực hiện song song:
cat test.txt | wc -l
cat test.txt | grep "a"
cat test.txt | head
echo "aabb"  > test.txt
echo "cc" >> test.txt
- Sử dụng vim: tạo file mới, sửa file, save,vvv
- Quản lý tiến trình: htop, ps aux, kill -9

```

##  Các command cơ bản
- cd: Thay đổi thư mục làm việc. Ví dụ: cd /home/myuser
- ls: Liệt kê nội dung thư mục hiện tại. Ví dụ: ls
- cp: Sao chép file hoặc thư mục. Ví dụ: cp file1.txt file2.txt
- mv: Di chuyển hoặc đổi tên file hoặc thư mục. Ví dụ: mv file1.txt file2.txt
- mkdir: Tạo thư mục mới. Ví dụ: mkdir new_dir
- cat: Hiển thị nội dung file văn bản. Ví dụ: cat test.txt
- head: Hiển thị phần đầu của file văn bản. Ví dụ: head -n 5 test.txt (hiển thị 5 dòng đầu tiên)

## Các command liên quan đến quyền

chmod: Thay đổi quyền truy cập cho file hoặc thư mục. Ví dụ: chmod 755 myfile.txt
chown: Thay đổi chủ sở hữu của file hoặc thư mục. Ví dụ: chown myuser:mygroup myfile.txt
ls -l: Liệt kê nội dung thư mục với chi tiết về quyền truy cập, chủ sở hữu, nhóm, kích thước, v.v.

## Các command thực hiện song song:

- Lệnh pipe (|) được sử dụng để kết nối đầu ra của một lệnh với đầu vào của lệnh khác. 
  - Ví dụ:
    cat test.txt | wc -l: Đếm số dòng trong file test.txt
    cat test.txt | grep "a": Tìm kiếm chuỗi "a" trong file test.txt
    cat test.txt | head: Hiển thị phần đầu của file test.txt
- Lệnh redirection (>` & >>) được sử dụng để ghi đầu ra của lệnh vào file. 
   - Ví dụ:
    echo "aabb" > test.txt: Tạo file test.txt với nội dung "aabb"
    echo "cc" >> test.txt: Thêm nội dung "cc" vào cuối file test.txt

## Sử dụng vim:

- Tạo file mới: vim new_file.txt
- Sửa file: Mở file bằng vim filename.txt. Sử dụng các phím điều khiển để di chuyển con trỏ, chỉnh sửa văn bản, v.v.
- Lưu và thoát: Nhập :wq để lưu thay đổi và thoát vim.

## Quản lý tiến trình:

- htop: Hiển thị danh sách tiến trình đang chạy với thông tin chi tiết về việc sử dụng CPU, bộ nhớ, v.v.
- ps aux: Liệt kê tất cả các tiến trình đang chạy với thông tin chi tiết về PID, người dùng, CPU, bộ nhớ, v.v.
- kill -9: Buộc dừng một tiến trình đang chạy. Ví dụ: kill -9 1234 (dừng tiến trình với PID 1234)