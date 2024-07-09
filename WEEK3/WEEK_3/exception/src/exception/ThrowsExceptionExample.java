package exception;

import java.io.IOException;

public class ThrowsExceptionExample {
	void aMethod() throws IOException {
		throw new IOException("Device error");
	}


	public static void main(String args[]) {
		try {
			ThrowsExceptionExample obj = new ThrowsExceptionExample();
			obj.aMethod();
		} catch (Exception e) {
			System.out.println("Exception handled!");
		}

		System.out.println("Hello Nga!");
	}
}
