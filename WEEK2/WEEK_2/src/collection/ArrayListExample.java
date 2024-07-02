package collection;

import java.util.ArrayList;

public class ArrayListExample {
	public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("ArrayList: " + list);

        list.remove(1);
        System.out.println("ArrayList after removal: " + list);
    }
}
