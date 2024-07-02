package design_pattern.singleton;

public class Singleton {
    private static Singleton instance;

    // Private constructor to prevent instantiation
    private Singleton() {
    }

    // Lazily initialize the singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and fields
}
