package design_pattern.singleton;

public class SingletonExample {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        // Both instance1 and instance2 should be the same instance
        System.out.println(instance1 == instance2);  // Output: true
    }
}
