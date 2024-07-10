
public interface LibraryDAO {
	void save(LibraryItem item);

	LibraryItem retrieve(String id);
}
