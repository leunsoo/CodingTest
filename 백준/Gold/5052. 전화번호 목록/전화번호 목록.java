import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		// 0~9의 숫
		Node[] children = new Node[10];
		
		boolean isEnd = false;
	}
	
	static class Trie {
		private Node root;
		
		public Trie() {
			root = new Node();
		}
		
		//전화번호 삽입
		//true: 일관성, false: 접두사 
		public boolean insert(String number) {
			Node curr = root;
			
			for(int i = 0; i < number.length(); ++i) {
				int digit = number.charAt(i) - '0';
				
				if(curr.isEnd) {
					return false;
				}
				
				if(curr.children[digit] == null) {
					curr.children[digit] = new Node();
				}
				
				curr = curr.children[digit];
			}
			curr.isEnd = true;
			
			return !hasChildren(curr);
		}
		
		private boolean hasChildren(Node node) {
			for(Node child : node.children) {
				if(child != null)
					return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while (t-- > 0) {
			int n =Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			
			boolean answer = true;
			
			String[] numbers = new String[n];
			for(int i = 0; i < n; ++i) {
				numbers[i] = br.readLine().trim();
			}
			Arrays.sort(numbers, (a,b) -> a.length() - b.length());
			
			for(String number : numbers ) {
				if(!trie.insert(number)) {
					answer = false;
					break;
				}
			}
			
			System.out.println(answer ? "YES" : "NO");
		}
	}
}