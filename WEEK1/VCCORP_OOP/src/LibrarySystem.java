
public class LibrarySystem {
    public static void main(String[] args) {
        LibraryDAO database = new InMemoryLibraryDatabase();

        LibraryItem book = new BorrowableBook("1", "Java Programming", "Author A");
        LibraryItem magazine = new Magazine("2", "Tech Magazine", 5);

        database.save(book);
        database.save(magazine);

        book.displayInfo();
        magazine.displayInfo();

        if (book instanceof Borrowable) {
            ((Borrowable) book).borrowItem("Member1");
            ((Borrowable) book).returnItem("Member1");
        }
    }
}