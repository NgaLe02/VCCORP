package collection;

public class ExampleAnotherHashCode {
	
	private int x;
	private int y;
	private int z;
	
	public ExampleAnotherHashCode(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + x;

		result = prime * result + y;
		
		result = prime * result + z;
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) {
			return false;
		}
		ExampleAnotherHashCode other = (ExampleAnotherHashCode)obj;
		if(x != other.x) return false;
		if(y != other.y) return false;
		if(z != other.z) return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "hehe [x=" + x + ", y=" + y + ", z=" + z + "]";
	}	
	
	public static void main(String[] args) {
		ExampleAnotherHashCode hehe1 = new ExampleAnotherHashCode(1,2,3);
		ExampleAnotherHashCode hehe2 = new ExampleAnotherHashCode(4,5,6);
		ExampleAnotherHashCode hehe3 = new ExampleAnotherHashCode(1,2,3);
		
	    String x = new String("hehe");
	    String y = new String("hehe");

	    System.out.println(x == y);
		
		System.out.println(hehe1 == hehe3);
	}
}
