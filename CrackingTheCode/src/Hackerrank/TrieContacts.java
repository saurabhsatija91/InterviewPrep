package Hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyTrieNode {
	int val = 0;
	MyTrieNode[] children = new MyTrieNode[26];
}

public class TrieContacts {
	public static MyTrieNode[] dictionary = new MyTrieNode[26];
	public static void add (String s) {
		MyTrieNode[] head = dictionary;
		
		for (int i = 0; i < s.length(); i++) {
			if (head[s.charAt(i) - 'a'] == null) {
				head[s.charAt(i) - 'a'] = new MyTrieNode();
			}
			head[s.charAt(i) - 'a'].val++;
			head = head[s.charAt(i) - 'a'].children;
		}
	}
	
	public static void find (String s) {
		MyTrieNode[] head = dictionary;
		int numOfContacts = 0;
		for (int i = 0; i < s.length(); i++) {
			if (head[s.charAt(i) - 'a'] == null) {
				System.out.println(0);
				return;
			} else {
				numOfContacts = head[s.charAt(i) - 'a'].val;
				head = head[s.charAt(i) - 'a'].children;
			}
		}
		System.out.println(numOfContacts);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            
            if(op.equals("add")) {
                add(contact);
            } else {
                find(contact);
            }
        }
	}
}
