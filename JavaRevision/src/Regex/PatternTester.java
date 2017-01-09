package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTester {
	public String regex;
	public String string;
	
	public void matchPattern() {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		
		while(matcher.find()) {
			System.out.println(regex + " matches:\n" +
							matcher.group() + " at index " +
							matcher.start() + " ending at " +
							matcher.end());
		}
	}
	
	public static void main(String[] args) {
		PatternTester app = new PatternTester();
		app.regex = "\\d";
		app.string = "%^*4";
		app.matchPattern();
	}
}
