package Book;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookmanagerTest {
    
    // 모든 테스트가 공동으로 사용할 책꽂이를 static으로 딱 하나만 준비합니다.
    static Bookmanager manager;

    @BeforeAll
    static void beforeAll() {
        manager = new Bookmanager();
    }

    @Test
    @Order(1)
    void testAddBook() {
        // 첫 번째 순서: 책을 넣고 잘 들어갔는지 확인합니다.
        manager.addBook("자바의 정석");
        assertTrue(manager.hasBook("자바의 정석"), "책 이름이 삽입되지 않았습니다.");
    }

    @Test
    @Order(2)
    void testRemoveBook() {
        // 두 번째 순서: 앞서 1번에서 넣었던 책을 지우고 잘 지워졌는지 확인합니다.
        manager.removeBook("자바의 정석");
        assertFalse(manager.hasBook("자바의 정석"), "책 이름이 삭제되지 않았습니다.");
    }
    
    @Test
    @Order(3)
    void testHasBook() {
        // 세 번째 순서: 책을 다시 넣은 뒤, 똑같은 책을 또 넣으려고 할 때 예외가 발생하는지 검사합니다.
        manager.addBook("자바의 정석");
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addBook("자바의 정석");
        }); 
    }
    
    @Test
    @Order(4)
    void testDontHasBook() {
        // 네 번째 순서: 책을 깔끔하게 지우고 비운 뒤, 없는 책을 또 지우려고 할 때 예외가 발생하는지 검사합니다.
        manager.removeBook("자바의 정석");
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeBook("자바의 정석");
        });
    }
}