package Book;

import java.util.HashSet;
import java.util.Set;

public class Bookmanager {
    private Set<String> books = new HashSet<>();

    public void addBook(String name) {
        if (books.contains(name)) {
            throw new IllegalArgumentException("이미 존재하는 책입니다: " + name);
        }
        books.add(name);
    }
    

    public void removeBook(String name) {
        if (!books.contains(name)) {
            throw new IllegalArgumentException("존재하지 않는 책입니다.");
        }
        books.remove(name);
    }
    

    public boolean hasBook(String name) {
        return books.contains(name);
    }
}