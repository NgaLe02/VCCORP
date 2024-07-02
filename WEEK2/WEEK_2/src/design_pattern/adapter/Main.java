package design_pattern.adapter;

public class Main {
	public static void main(String[] args) {
		OldPrinter oldPrinter = new OldPrinter();
		NewPrinter adapter = new PrinterAdapter(oldPrinter);

		adapter.printDocument("Hello, World!"); // Output: Old Printer: Hello, World!
	}
}
