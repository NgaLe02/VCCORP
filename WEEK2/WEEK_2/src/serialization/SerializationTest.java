package serialization;

import java.io.*;

class Parent implements Serializable {
    private static final long serialVersionUID = 1L;
    int parentField;
    
    Parent(int parentField) {
        this.parentField = parentField;
    }
}

class Child extends Parent {
    private static final long serialVersionUID = 1L;
    int childField;
    
    Child(int parentField, int childField) {
        super(parentField);
        this.childField = childField;
    }
}

public class SerializationTest {
    public static void main(String[] args) {
        Child child = new Child(10, 20);
        
        // Tuần tự hóa đối tượng Child
        try (FileOutputStream fileOut = new FileOutputStream("child.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(child);
            System.out.println("Child object serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
        
        // Giải tuần tự hóa đối tượng Child
        Child deserializedChild = null;
        try (FileInputStream fileIn = new FileInputStream("child.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedChild = (Child) in.readObject();
            System.out.println("Child object deserialized");
            System.out.println("Parent Field: " + deserializedChild.parentField);
            System.out.println("Child Field: " + deserializedChild.childField);
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}
