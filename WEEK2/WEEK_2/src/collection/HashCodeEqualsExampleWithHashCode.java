package collection;
import java.util.HashSet;
import java.util.Objects;

class Person2 {
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person = (Person2) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
    	System.out.println(Objects.hash(name, age));
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class HashCodeEqualsExampleWithHashCode {
    public static void main(String[] args) {
        HashSet<Person2> set = new HashSet<>();
        Person2 p1 = new Person2("Nga", 30);
        Person2 p2 = new Person2("Khanh", 25);
        Person2 p3 = new Person2("Nga", 30); // Trùng với p1

        set.add(p1);
        set.add(p2);
        set.add(p3); // Sẽ không thêm vào set vì trùng với p1 (có sử dụng hashcode)
        
        System.out.println("HashSet: " + set);
    }
}
