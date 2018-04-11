package stringInCodeFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class RegexParser {

	public static Pattern toRegex(SearchType sType) {
		String returnType = sType.returnType;
		String name = sType.name;
		List<StringBuffer> params = new ArrayList<StringBuffer>();
		
		for (StringBuffer b : sType.params) {
			params.add(new StringBuffer(b.toString()));
		}
		
		StringBuffer pattern = new StringBuffer();
		pattern.append(returnType);
		pattern.append("[ ]*");
		pattern.append(name);
		pattern.append("[ ]*\\([ ]*");
		
		if (params != null && !params.isEmpty()) {
			for (StringBuffer p : params) {
				int delimiter = p.indexOf(" ");
				p.replace(delimiter, delimiter +1, "#");	/* replace the whitespace separating returnType and parameter name with # for later retrieval */
				int lastStarIndex = 0;
				int currentStarIndex = p.indexOf("*", lastStarIndex);
				
				while ((currentStarIndex != -1) && (p.charAt(currentStarIndex -1) != '\\')) {
					p.insert(currentStarIndex, "[ ]*\\");
					lastStarIndex = currentStarIndex +6;
					currentStarIndex = p.indexOf("*", lastStarIndex);
				}
				
				delimiter = p.indexOf("#");
				p.replace(delimiter, delimiter +1, " ");	/* exchange the # delimiter with a normal whitespace */
				pattern.append(p.substring(0, delimiter)); 	/* return type */
				pattern.append("[ ]*");
				pattern.append(p.substring(delimiter +1, p.length())); 	/* parameter */
				pattern.append("[ ]*,[ ]*");
			}
			pattern.delete(pattern.lastIndexOf(",[ ]*"), pattern.length());
		} else {
			pattern.append("void[ ]*");
		}
		
		pattern.append("\\)");
		return Pattern.compile(pattern.toString());
	}
	
}
