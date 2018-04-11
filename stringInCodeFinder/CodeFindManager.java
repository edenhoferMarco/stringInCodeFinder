package stringInCodeFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CodeFindManager {
	private FileManager fileMan = new FileManager();
	private List<String> wordList;
	List<SearchType> workingList;
	Scanner codeScanner;
	
	public void setWorkingFilesPaths(String wordPath, String codePath) {
		fileMan.setWorkingFilesPaths(wordPath, codePath);
	}
	
	public boolean run() {
		// wordList = fileMan.getWordList();
		codeScanner = fileMan.getCodeFileScanner();
		findStringInCode();
		return false;
	}
	

	
	private void findStringInCode() {
		String found;
		initTestWorkingList();
		for (SearchType sType : workingList) {
			//sType.setSearchPattern(RegexParser.toRegex(sType));
			System.out.println(sType.searchPattern);
			if ((found = codeScanner.findWithinHorizon(sType.searchPattern, 0)) != null) {
				this.foundString(found);
			}
		}
		codeScanner.close();
	}
	
	private void initTestWorkingList() {
		List<StringBuffer> params = new ArrayList<StringBuffer>();
		
		
		workingList = new ArrayList<SearchType>();
		workingList.add(new SearchType("void", "main", params));
		
		params = new ArrayList<StringBuffer>();
		params.add(new StringBuffer("int* p1"));
		
		workingList.add(new SearchType("void", "func2" , params));
		
		params = new ArrayList<StringBuffer>();
		params.add(new StringBuffer("int p3"));
		params.add(new StringBuffer("String s3"));
		params.add(new StringBuffer("float** f3"));
		workingList.add(new SearchType("int", "func3" , params));
		
	}
	
	private void foundString(String searchstring) {
		System.out.println("Found the String: " +searchstring);
	}
	
	private void writeToLog(String message) {
		
	}
	
	
}
