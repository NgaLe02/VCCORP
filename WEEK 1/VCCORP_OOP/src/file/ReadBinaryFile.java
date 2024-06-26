package file;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryFile {
	 public static void main(String[] args) {
	        String fileName = "example.dat";
	        try (FileInputStream fis = new FileInputStream(fileName)) {
	            int byteContent;
	            while ((byteContent = fis.read()) != -1) {
	                System.out.print(byteContent + " ");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
