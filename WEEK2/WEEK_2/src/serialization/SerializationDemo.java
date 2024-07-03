package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) {
		Student student = new Student("John Doe", 20, "q1343545");

		// Serialize the object
		try (FileOutputStream fileOut = new FileOutputStream("student.data");
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(student);
			System.out.println("Serialized data is saved in student.data");
		} catch (IOException i) {
			i.printStackTrace();
		}

		// Deserialize the object
		Student deserializedStudent = null;
		try (FileInputStream fileIn = new FileInputStream("student.data");
				ObjectInputStream in = new ObjectInputStream(fileIn)) {
			deserializedStudent = (Student) in.readObject();
			System.out.println("Deserialized Student:" + deserializedStudent);

		} catch (IOException | ClassNotFoundException i) {
			i.printStackTrace();
		}
	}
}
