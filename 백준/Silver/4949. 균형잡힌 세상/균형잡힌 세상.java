import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	String str = br.readLine();
        	String answer = "yes";
        	
        	if(str.equals(".")) {
        		System.out.println(sb);
        		return;
        	}
        	
        	ArrayDeque<Character> dq = new ArrayDeque<>();
        	for(int i = 0; i < str.length(); ++i) {
        		char c = str.charAt(i);
        		
        		if(!isBalance(dq, c)) {
        			answer = "no";
        			break;
        		}
        	}
        	
        	if(!dq.isEmpty()) answer = "no";
        	
        	sb.append(answer).append("\n");
        }
    }
    
    static boolean isBalance(ArrayDeque<Character> dq, char c) {
    	if(c != ')' && c != ']' && c != '(' && c != '[') return true;
    	if(c == ')' || c == ']') {
    		if(dq.isEmpty()) return false;
    		
    		char qc = dq.pollLast(); 

        	if(qc == ']' || qc == ')') return false;
        	if(qc == '(' && c == ']') return false;
        	if(qc == '[' && c == ')') return false;
    	}
    	else {
        	dq.addLast(c);	
		}
    	
    
    	return true;
    }
}