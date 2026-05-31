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
    

    //remove book 구현해주세요
    

    public boolean hasBook(String name) {
        return books.contains(name);
    }
}