// Implementing the database interface

import java.util.HashMap;
import java.util.Map;

class InMemoryLibraryDatabase implements LibraryDAO {
    private Map<String, LibraryItem> database = new HashMap<>();

    @Override
    public void save(LibraryItem item) {
        database.put(item.getId(), item);
    }

    @Override
    public LibraryItem retrieve(String id) {
        return database.get(id);
    }
}