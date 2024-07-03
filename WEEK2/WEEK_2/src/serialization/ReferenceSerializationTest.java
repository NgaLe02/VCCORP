package serialization;

import java.io.*;

class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    String city;
    
    Address(String city) {
        this.city = city;
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    transient Address address; // Biến transient sẽ không được tuần tự hóa
    
    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

public class ReferenceSerializationTest {
    public static void main(String[] args) {
        Address address = new Address("New York");
        Person person = new Person("John Doe", address);
        
        // Tuần tự hóa đối tượng Person
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(person);
            System.out.println("Person object serialized");
        } catch (IOException i) {
            i.printStackTrace();
        }
        
        // Giải tuần tự hóa đối tượng Person
        Person deserializedPerson = null;
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            deserializedPerson = (Person) in.readObject();
            System.out.println("Person object deserialized");
            System.out.println("Name: " + deserializedPerson.name);
            System.out.println("Address: " + deserializedPerson.address); // Sẽ là null vì address là transient
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
    }
}
