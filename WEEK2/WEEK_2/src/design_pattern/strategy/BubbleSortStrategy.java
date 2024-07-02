package design_pattern.strategy;

//Các thuật toán sắp xếp cụ thể

public class BubbleSortStrategy implements SortStrategy{

	@Override
	public void sort(int[] numbers) {
		 System.out.println("Đang sắp xếp bằng Bubble Sort");
	}

}
