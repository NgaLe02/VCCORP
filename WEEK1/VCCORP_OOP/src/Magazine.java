// Another subclass for polymorphism
public class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String id, String title, int issueNumber) {
        super(id, title);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine ID: " + getId() + ", Title: " + getTitle() + ", Issue Number: " + issueNumber);
    }
}