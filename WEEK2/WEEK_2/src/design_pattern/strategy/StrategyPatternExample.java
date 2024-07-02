package design_pattern.strategy;

//Ví dụ sử dụng Strategy Pattern

public class StrategyPatternExample {
	public static void main(String[] args) {
		int[] numbers = { 5, 1, 9, 3, 7 };

		SortContext context = new SortContext(new BubbleSortStrategy());
		context.sortNumbers(numbers);

		context.setStrategy(new QuickSortStrategy());
		context.sortNumbers(numbers);
	}
}
