package file;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinaryFile {
	public static void main(String[] args) {
        String fileName = "example.dat";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            // Example data to write (array of bytes)
            byte[] data = {1, 2, 3, 4, 5};
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
