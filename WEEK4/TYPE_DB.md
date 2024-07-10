Yêu cầu (3): Tìm hiểu về các loại db và trình bày lại (ít nhất 3 db thuộc loại sql, 3 db thuộc loại no sql). các khái niệm CAP, BASE, ACID, 3 dạng chuẩn của csdl.

ACID là một thuật ngữ được sử dụng trong cơ sở dữ liệu để mô tả các tính chất cần thiết để đảm bảo tính toàn vẹn của giao dịch. Đây là một viết tắt cho các từ khóa sau đây:

Atomicity (Tính nguyên tử): Giao dịch được coi là hoàn thành hoặc không hoàn thành toàn bộ. Điều này có nghĩa là nếu một phần của giao dịch thất bại, toàn bộ giao dịch sẽ bị hủy và không có thay đổi nào được áp dụng vào cơ sở dữ liệu.

Consistency (Tính nhất quán): Cơ sở dữ liệu phải ở trạng thái hợp lý trước và sau khi giao dịch được thực thi. Điều này đảm bảo rằng dữ liệu không bị vi phạm các ràng buộc quyền lực, quan hệ hay ràng buộc ngữ nghĩa.

Isolation (Tính độc lập): Mỗi giao dịch được thực hiện độc lập với các giao dịch khác, điều này ngăn chặn các thay đổi không mong muốn xảy ra khi nhiều giao dịch đang thực hiện đồng thời. Isolation đảm bảo tính nhất quán của cơ sở dữ liệu trong khi nhiều giao dịch đang diễn ra.

Durability (Tính bền vững): Sau khi giao dịch được thực hiện và giao dịch được xác nhận thành công, các thay đổi được áp dụng vào cơ sở dữ liệu sẽ không bị mất do lỗi hệ thống hay lỗi phần cứng. Dữ liệu đã được lưu trữ sẽ được bảo vệ và khôi phục khi cần thiết.

Các tính chất này cùng nhau tạo nên ACID để đảm bảo tính toàn vẹn và nhất quán của dữ liệu trong các hệ thống cơ sở dữ liệu. Các hệ thống quản lý cơ sở dữ liệu (DBMS) như MySQL cung cấp hỗ trợ ACID bằng cách triển khai các giải pháp và thuật toán phù hợp để đảm bảo các tính chất này cho các giao dịch dữ liệu.
