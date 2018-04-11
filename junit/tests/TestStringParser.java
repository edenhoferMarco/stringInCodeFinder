package junit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stringInCodeFinder.SearchType;

class TestStringParser {
	SearchType s = new SearchType("void ASDM_Cbk(int* param1, int param2, char** param3)");
	SearchType noParams = new SearchType("Std_ReturnType ASDM_init()");
	
	@Test
	void testReturnType() {
		assertEquals(s.returnType, "void");
	}
	
	@Test
	void testName() {
		assertEquals(s.name, "ASDM_Cbk");
	}
	
	@Test
	void testParam1() {
		assertEquals(s.params.get(0).toString(), "int* param1");
	}
	
	@Test
	void testParam2() {
		assertEquals(s.params.get(1).toString(), "int param2");
	}
	
	@Test
	void testParam3() {
		assertEquals(s.params.get(2).toString(), "char** param3");
	}
	
	@Test
	void testNoParams() {
		assertTrue(noParams.params.isEmpty());
	}

}
