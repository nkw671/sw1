package student;

import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {
	
	static StudentManager student;
/*
	@BeforeEach
	void setUp() throws Exception {
		
		student = new StudentManager();
	}
	*/
	@BeforeAll
	static void beforeAll() {
	 student = new StudentManager();
	}

	    

	@Test
	@Order(1)
	void testAddStudent() {
		
		student.addStudent("홍길동");
		assertTrue( student.hasStudent("홍길동"), "이름이 삽입되지 않았습니다." );
		
	}

	@Test
	@Order(2)
	void testRemoveStudent() {
		//student.addStudent("홍길동");
		student.removeStudent("홍길동");
		assertFalse(student.hasStudent("홍길동"), "이름이 삭제되지 않았습니다");
	}
	
	@Test
	@Order(3)
	void testHasStudent() {
		student.addStudent("홍길동");
		assertThrows(IllegalArgumentException.class, () -> {student.addStudent("홍길동");});	
		
	}
	
	@Test
	@Order(4)
	void testDontHasStudent() {
		student.removeStudent("홍길동");
		assertThrows(IllegalArgumentException.class, () -> {student.removeStudent("홍길동");});
	}
}
