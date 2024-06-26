// Abstraction
public abstract class LibraryItem {
	private String id;
    private String title;

    public LibraryItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayInfo();
}
