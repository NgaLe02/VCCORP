// Encapsulation and Inheritance
public class Book extends LibraryItem {
    private String author;

    public Book(String id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void displayInfo() {
        System.out.println("Book ID: " + getId() + ", Title: " + getTitle() + ", Author: " + author);
    }
}