package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private transient String password; // không tuần tự hóa trực tiếp
//	private int gender;

	Student(String name, int age, String password) {
		this.name = name;
		this.age = age;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student{name='" + name + "', age=" + age + ", password='" + password + "'}";
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		// Mã hóa mật khẩu trước khi ghi nó vào luồng
//		String encryptedPassword = "encrypted_" + password; // Giả sử đây là mật khẩu đã mã hóa
//		System.out.println("hehe");
//
//		out.writeObject(encryptedPassword);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		// Giải mã mật khẩu sau khi đọc nó từ luồng
//		String encryptedPassword = (String) in.readObject();
//		this.password = encryptedPassword.replace("encrypted_", ""); // Giả sử đây là quá trình giải mã
	}

}
