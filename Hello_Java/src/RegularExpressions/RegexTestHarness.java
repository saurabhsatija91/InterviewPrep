package RegularExpressions;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {
	public static void main(String[] args) {
/*	Console console = System.console();
	if (console == null) {
		System.err.println("No console.");
		System.exit(1);
	}*/
		Pattern pattern =
				Pattern.compile("foo");
		Matcher matcher =
				pattern.matcher("foofoofoo");
		
		boolean found = false;
		while (matcher.find()) {
			System.out.format("I found the text" +
					" \"%s\" starting at " +
					"index %d and ending at index %d.%n",
					matcher.group(),
					matcher.start(),
					matcher.end());
			found = true;
		}
		if (!found)
			System.out.println("No match found.");
	}
}
