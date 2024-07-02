package design_pattern.strategy;

//Context sử dụng Strategy

public class SortContext {
	private SortStrategy strategy;

	public SortContext(SortStrategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(SortStrategy strategy) {
		this.strategy = strategy;
	}

	public void sortNumbers(int[] numbers) {
		strategy.sort(numbers);
	}
}
