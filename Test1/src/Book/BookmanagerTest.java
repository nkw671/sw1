package Book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookmanagerTest {
    
	//검사용 주석
    static Bookmanager manager;

    @BeforeAll
    static void beforeAll() {
        manager = new Bookmanager();
    }

    @Test
    @Order(1)
    void testAddBook() {
        manager.addBook("자바의 정석");
        assertTrue(manager.hasBook("자바의 정석"), "책 이름이 삽입되지 않았습니다.");
    }

    @Test
    @Order(2)
    void testRemoveBook() {
        manager.removeBook("자바의 정석");
        assertFalse(manager.hasBook("자바의 정석"), "책 이름이 삭제되지 않았습니다.");
    }
    
    @Test
    @Order(3)
    void testHasBook() {
        manager.addBook("자바의 정석");
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addBook("자바의 정석");
        }); 
    }
    
    @Test
    @Order(4)
    void testDontHasBook() {
        manager.removeBook("자바의 정석");
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeBook("자바의 정석");
        });
    }
}