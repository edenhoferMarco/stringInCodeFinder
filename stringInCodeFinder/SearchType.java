package stringInCodeFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SearchType {
	public String returnType;
	public String name;
	public List<StringBuffer> params;
	public Pattern searchPattern;
	
	public SearchType(String fullSignature) {
		StringBuffer workingSignature = new StringBuffer(fullSignature);
		
		workingSignature = extractReturnType(workingSignature);
		workingSignature = extractName(workingSignature);
		workingSignature = extractParameters(workingSignature);
		this.searchPattern = RegexParser.toRegex(this);
	}
	
	public SearchType(String returnType, String name, List<StringBuffer> params) {
		this.returnType = returnType;
		this.name = name;
		this.params = params;
		this.searchPattern = RegexParser.toRegex(this);
	}
	
	public void setSearchPattern(Pattern searchPattern) {
		this.searchPattern = searchPattern;
	}
	
	private StringBuffer extractReturnType(StringBuffer signature) {
		this.returnType = signature.substring(0, signature.indexOf(" "));
		
		return new StringBuffer(signature.substring(signature.indexOf(" "), signature.length()).trim());
	}
	
	private StringBuffer extractName(StringBuffer signature) {
		this.name = signature.substring(0, signature.indexOf("("));
		
		return new StringBuffer(signature.substring(signature.indexOf("(") +1, signature.length()).trim());
	}
	
	private StringBuffer extractParameters(StringBuffer signature) {
		List<StringBuffer> tmpParams = new ArrayList<StringBuffer>();
		
		while (signature.indexOf(",") != -1) {
			tmpParams.add(new StringBuffer(signature.substring(0, signature.indexOf(","))));
			signature = new StringBuffer(signature.substring(signature.indexOf(",") +1, signature.length()).trim());
			System.out.println("signature params: " +signature);
		}
		if (signature.length() > 1) {
			tmpParams.add(new StringBuffer(signature.substring(0, signature.indexOf(")"))));
		}
		
		this.params = tmpParams;
		return null; /* null wanted, since workingString is no longer needed */
	}
}
