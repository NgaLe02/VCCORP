package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConcurrentHashMapAtomicsExample {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

		// putIfAbsent example
		map.put("key1", 1);
		Integer oldValue = map.putIfAbsent("key1", 10); // key1 already exists, oldValue = 1
		System.out.println("putIfAbsent - Old value of key1: " + oldValue);

		// remove example
		boolean removed = map.remove("key1", 1); // Remove key1 with value 1
		System.out.println("remove - Removed key1 with value 1: " + removed);

		// replace example
		boolean replaced = map.replace("key1", 1, 100); // Replace key1 value 1 with 100
		System.out.println("replace - Replaced key1 value 1 with 100: " + replaced);

		// computeIfAbsent example
		map.computeIfAbsent("key2", key -> 20); // Compute value for key2 if absent
		System.out.println("computeIfAbsent - Value of key2: " + map.get("key2"));

		// computeIfPresent example
		map.computeIfPresent("key2", (key, value) -> value + 5); // Compute value for key2 if present
		System.out.println("computeIfPresent - Updated value of key2: " + map.get("key2"));

		// compute example
		map.compute("key2", (key, value) -> value + 10); // Compute value for key2 unconditionally
		System.out.println("compute - Updated value of key2: " + map.get("key2"));

		// merge example
		map.merge("key2", 5, (oldValue2, newValue2) -> oldValue2 + newValue2); // Merge value for key2
		System.out.println("merge - Merged value of key2: " + map.get("key2"));
	}
}
