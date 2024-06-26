package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileAndFolder {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Enter the directory path:");
	        String directoryPath = scanner.nextLine();

	        File directory = new File(directoryPath);
	        if (directory.exists() && directory.isDirectory()) {
	            File[] files = directory.listFiles();
	            if (files != null && files.length > 0) {
	                System.out.println("Files in directory:");
	                for (File file : files) {
	                    if (file.isFile()) {
	                        System.out.println("File: " + file.getName());
	                    } else if (file.isDirectory()) {
	                        System.out.println("Directory: " + file.getName());
	                    }
	                }

	                System.out.println("\nEnter the name of the file to read:");
	                String fileName = scanner.nextLine();
	                File fileToRead = new File(directoryPath, fileName);

	                if (fileToRead.exists() && fileToRead.isFile()) {
	                    try (BufferedReader reader = new BufferedReader(new FileReader(fileToRead))) {
	                        String line;
	                        while ((line = reader.readLine()) != null) {
	                            System.out.println(line);
	                        }
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                } else {
	                    System.out.println("The file does not exist.");
	                }
	            } else {
	                System.out.println("The directory is empty.");
	            }
	        } else {
	            System.out.println("The directory does not exist.");
	        }

	        scanner.close();
	    }
}
