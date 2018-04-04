package stringInCodeFinder;

import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	private String pathToWords;
	private String pathToCode;
	private BufferedReader wordsReader;
	private String logMessage = "";
	List<String> wordList;
	
	public void setWorkingFilesPaths(String wordPath, String codePath) {
		this.setWordPath(wordPath);
		this.setCodePath(codePath);
	}
	
	public List<String> getWordList() {
		makeSearchWordList();
		return wordList;
	}
	
	public Scanner getCodeFileScanner() {
		Scanner codeFileScanner = null;
		
		try {
			codeFileScanner = new Scanner(new File(pathToCode));
		} catch (FileNotFoundException e) {
			logMessage += "ERROR: path to Code not a file \n";
			e.printStackTrace();
		}
		
		return codeFileScanner;
	}
	
	public String getLogMessage() {
		return logMessage;
	}
	
	private void makeSearchWordList() {
		wordList = new ArrayList<String>();
		String word;
		
		this.openWordsReader();
		
		try {
			while((word = wordsReader.readLine()) != null) {
				wordList.add(word);
			}
			
		} catch (IOException e) {
			/* TODO write exception handling*/
		} finally {
			if (wordsReader != null) {
				try {
					wordsReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void openWordsReader() {
		try {
			wordsReader = new BufferedReader(new FileReader(pathToWords));
		} catch (FileNotFoundException e) {
			logMessage += "ERROR: path to Words not a file \n";
			e.printStackTrace();
		} 
	}
	
	private void setCodePath(String codePath) {
		this.pathToCode = codePath;
	}
	
	private void setWordPath(String wordPath) {
		this.pathToWords = wordPath;
	}
}
