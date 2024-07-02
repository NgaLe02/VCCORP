package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Example {
	  public static void main(String[] args) {
	        // Sử dụng ArrayList để lưu trữ danh sách các số nguyên
	        ArrayList<Integer> numberList = new ArrayList<>();
	        numberList.add(10);
	        numberList.add(20);
	        numberList.add(30);
	        numberList.add(40);
	        numberList.add(20); // Thêm số trùng lặp để minh họa cho HashSet

	        // Sử dụng HashSet để loại bỏ các số trùng lặp trong danh sách
	        HashSet<Integer> uniqueNumbers = new HashSet<>(numberList);
	        System.out.println("Unique numbers: " + uniqueNumbers);

	        // Sử dụng HashMap để đếm số lần xuất hiện của từng số
	        HashMap<Integer, Integer> numberCount = new HashMap<>();
	        for (Integer number : numberList) {
	            if (numberCount.containsKey(number)) {
	                numberCount.put(number, numberCount.get(number) + 1);
	            } else {
	                numberCount.put(number, 1);
	            }
	        }
	        System.out.println("Number counts: " + numberCount);
	    }
}
