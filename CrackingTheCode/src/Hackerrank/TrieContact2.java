package Hackerrank;

public class TrieContact2 {
	public static class Node {
		private static int NUM_OF_CHAR = 26;
		int val;
		Node[] children = new Node[NUM_OF_CHAR];
		
		private static int getCharIndex(char c) {
			return (c - 'a');
		}
		private Node getNode(char c) {
			return children[getCharIndex(c)];
		}
		
		private void setNode(char c, Node node) {
			children[getCharIndex(c)] = node;
		}
		public void add (String s) {
			add(s, 0);
		}
		private void add(String s, int index) {
			val++;
			if (index == s.length()) return;
			
			char current = s.charAt(index);
			Node child = getNode(current);
			if (child == null) {
				child = new Node();
				setNode(current, child);
			}
			child.add(s, index + 1);
		}
		
		public int findCount(String s, int index) {
			if (index == s.length())
				return val;
			Node child = getNode(s.charAt(index));
			if (child == null) {
				return 0;
			}
			return child.findCount(s, index + 1);
		}
		
		
	}
}
