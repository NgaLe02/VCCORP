package collection;

import java.util.HashSet;

public class HashSetExample {
	 public static void main(String[] args) {
	        HashSet<Integer> set = new HashSet<>();
	        set.add(1);
	        set.add(2);
	        set.add(3);
	        set.add(2); // Thêm số trùng lặp

	        System.out.println("HashSet contains 2: " + set.contains(2));
	        System.out.println("HashSet: " + set);

	        set.remove(2);
	        System.out.println("HashSet after removal: " + set);
	    }
}
