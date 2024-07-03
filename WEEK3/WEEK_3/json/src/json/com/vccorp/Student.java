package json.com.vccorp;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private transient String password; // không tuần tự hóa trực tiếp

	public Student() {
	}

	Student(String name, int age, String password) {
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student{name='" + name + "', age=" + age + ", password='" + password + "'}";
	}

}
