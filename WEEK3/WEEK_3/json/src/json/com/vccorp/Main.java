package json.com.vccorp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) {
		Student student = new Student("Nga ", 21, "khongbiet");

		// Tuần tự hóa đối tượng thành JSON và lưu vào tệp
		try (FileWriter file = new FileWriter("student.json")) {
			JSONObject jsonObject = new JSONObject(student);
			
			file.write(jsonObject.toString());
			System.out.println(jsonObject.toString());
			System.out.println("Đối tượng Student đã được tuần tự hóa thành JSON và lưu vào student.json");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Giải tuần tự hóa đối tượng từ tệp JSON
		try (BufferedReader reader = new BufferedReader(new FileReader("student.json"))) {
			StringBuilder jsonContent = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonContent.append(line);
			}
			// dùng json
			JSONObject jsonObject = new JSONObject(jsonContent.toString());
			Student deserializedStudent = new Student();
			deserializedStudent.setName(jsonObject.getString("name"));
			deserializedStudent.setAge(jsonObject.getInt("age"));
			// Không cần giải tuần tự hóa mật khẩu vì nó là transient
			System.out.println("Đối tượng Student đã được giải tuần tự hóa từ JSON:");
			System.out.println(deserializedStudent);

			// dùng gson
			Gson gson = new Gson();
			Student studentFromGson = gson.fromJson(jsonContent.toString(), Student.class);
			System.out.println("Đối tượng Student đã được giải tuần tự hóa từ JSON (dùng Gson):");
			System.out.println(studentFromGson);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
