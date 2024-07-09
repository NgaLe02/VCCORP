package exception;

public class ThrowExceptionExample {

	public static void main(String[] args) {
		ageValid(19);
		System.out.println("------");
		ageValid(17);
	}

	public static void ageValid(int age) {
		if (age < 18) {
			throw new ArithmeticException("Age not valid!");
		} else {
			System.out.println("Welcome!");
		}
	}
}
