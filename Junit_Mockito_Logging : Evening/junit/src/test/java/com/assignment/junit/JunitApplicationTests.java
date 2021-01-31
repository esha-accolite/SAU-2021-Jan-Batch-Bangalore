package com.assignment.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class JunitApplicationTests {

	@Test
	public void testcase1() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(1900);
		assertEquals(false, actual);
	}
	
	@Test
	public void testcase2() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(2016);
		assertEquals(true, actual);
	}
	
	@Test
	public void testcase3() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(2020);
		assertEquals(true, actual);
	}
	
	
	@Test
	public void testcase4() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(1991);
		assertEquals(false, actual);
	}
	
	@Test
	public void testcase5() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(2004);
		assertEquals(true, actual);
	}
	
	@Test
	public void testcase6() {
		LeapYear yrObj = new LeapYear();
		boolean actual = yrObj.isleapyear(1994);
		assertEquals(false, actual);
	}
	
	Student mock1 = new Student();
	Subject mock2 = new Subject();

	@Test
	public void testLowerCase() {
		Student mock1 = mock(Student.class);
		when(mock1.getName()).thenReturn("Esha Jaiswal");
		String str = mock2.tolower(mock1);
		assertEquals("esha jaiswal", str);
	}

	@Test
	public void testRoleCourse() {
		Subject mock2 = mock(Subject.class);
		when(mock2.getSubject()).thenReturn("Data Structures and Algorithms");
		String res = mock1.roleCourse(mock2);
		assertEquals("Subject is: Data Structures and Algorithms", res);
	}

}
