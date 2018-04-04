package stringInCodeFinder;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class JUnitTestClass {
	
	@Test
	void testFileOpen() {
		FileManager fileMan = new FileManager();
		fileMan.setWordPath("/home/marco/eclipse-workspace/stringInCodeFinder/testFiles/words.txt");
		try {
			fileMan.openWords();
			assertNotNull(fileMan.wordsReader);
		} catch (IOException e) {
			fail("IOException");
			e.printStackTrace();
		}
	}
	
	@Test
	void testCodeOpen() {
		FileManager fileMan = new FileManager();
		fileMan.setCodePath("/home/marco/eclipse-workspace/stringInCodeFinder/testFiles/code.c");
		try {
			fileMan.openCode();
			assertNotNull(fileMan.codeReader);
		} catch (IOException e) {
			fail("IOException");
			e.printStackTrace();
		}
	}
}
