package stringInCodeFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CodeFindManager {
	private FileManager fileMan = new FileManager();
	private List<String> wordList;
	Scanner codeScanner;
	
	public void setWorkingFilesPaths(String wordPath, String codePath) {
		fileMan.setWorkingFilesPaths(wordPath, codePath);
	}
	
	public boolean run() {
		wordList = fileMan.getWordList();
		codeScanner = fileMan.getCodeFileScanner();
		findStringInCode();
		return false;
	}
	

	
	private void findStringInCode() {
		for (String searchString : wordList) {
			if (codeScanner.findWithinHorizon(searchString, 0) != null) {
				this.foundString(searchString);
			}
		}
		codeScanner.close();
	}
	
	private void foundString(String searchstring) {
		System.out.println("Found the String: " +searchstring);
	}
	
	private void writeToLog(String message) {
		
	}
}
