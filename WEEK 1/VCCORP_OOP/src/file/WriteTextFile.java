package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextFile {
    public static void main(String[] args) {
        String fileName = "example.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Hello, this is a text file!");
            writer.newLine();
            writer.write("This is the second line.");
            // In ra đường dẫn tuyệt đối của file
            File file = new File(fileName);
            System.out.println("File được tạo tại: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}