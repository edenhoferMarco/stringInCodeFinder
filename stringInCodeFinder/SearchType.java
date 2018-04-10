package stringInCodeFinder;

import java.util.List;
import java.util.regex.Pattern;

public class SearchType {
	public String returnType;
	public String name;
	public List<StringBuffer> params;
	public Pattern searchPattern;
	
	public SearchType(String returnType, String name, List<StringBuffer> params) {
		this.returnType = returnType;
		this.name = name;
		this.params = params;
	}
	
	public void setSearchPattern(Pattern searchPattern) {
		this.searchPattern = searchPattern;
	}
}
