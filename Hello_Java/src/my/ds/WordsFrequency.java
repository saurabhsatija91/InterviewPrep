package my.ds;

import java.util.*;

public class WordsFrequency {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		Map<String, Integer> mOverride = new HashMap<String, Integer>();
		
		for (String a : args) {
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}
		
		System.out.println(m.size() + " distinct words:");
        System.out.println(m);
        
        mOverride.put("satija", 5);
        mOverride.put("saurabh", 5);
        System.out.println(mOverride);
        m.putAll(mOverride);
        System.out.println(m);
        System.out.println(m.entrySet());
	}
}
