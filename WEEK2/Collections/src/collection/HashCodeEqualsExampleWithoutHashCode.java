package collection;
import java.util.HashSet;
import java.util.Objects;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class HashCodeEqualsExampleWithoutHashCode {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("Nga", 30);
        Person p2 = new Person("Khanh", 25);
        Person p3 = new Person("Nga", 30); // Trùng với p1

        set.add(p1);
        set.add(p2);
        set.add(p3); // Sẽ được thêm vào set mặc dù trùng với p1 vì ko dùng hashcode
        //Vì  không ghi đè hashCode, phương thức mặc định từ lớp Object sẽ được sử dụng,
        //dẫn đến mỗi đối tượng có một mã băm duy nhất dựa trên vị trí của chúng trong bộ nhớ.
        
        System.out.println("HashSet: " + set);
    }
}
