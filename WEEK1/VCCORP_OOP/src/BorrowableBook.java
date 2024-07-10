// Implementing Borrowable in Book class
public class BorrowableBook extends Book implements Borrowable {
    private boolean isBorrowed = false;
    private String borrowedBy;

    public BorrowableBook(String id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public void borrowItem(String memberId) {
        if (!isBorrowed) {
            isBorrowed = true;
            borrowedBy = memberId;
            System.out.println("Book borrowed by: " + memberId);
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    @Override
    public void returnItem(String memberId) {
        if (isBorrowed && borrowedBy.equals(memberId)) {
            isBorrowed = false;
            borrowedBy = null;
            System.out.println("Book returned by: " + memberId);
        } else {
            System.out.println("Book not borrowed by this member.");
        }
    }
}