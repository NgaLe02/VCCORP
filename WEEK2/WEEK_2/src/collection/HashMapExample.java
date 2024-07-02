package collection;

import java.util.HashMap;

public class HashMapExample {
	  public static void main(String[] args) {
	        HashMap<String, Integer> map = new HashMap<>();
	        map.put("One", 1);
	        map.put("Two", 2);
	        map.put("Three", 3);

	        System.out.println("Value for key 'One': " + map.get("One"));
	        System.out.println("Map contains key 'Two': " + map.containsKey("Two"));
	        
	        map.remove("Two");
	        System.out.println("Map contains key 'Two' after removal: " + map.containsKey("Two"));
	    }
}
