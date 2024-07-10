
// Open/Closed Principle and Interface Segregation PrincipleS
public interface Borrowable {
	void borrowItem(String memberId);

	void returnItem(String memberId);
}
