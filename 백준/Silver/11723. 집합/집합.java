import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int M = Integer.parseInt(br.readLine());
    	
    	boolean[] arr = new boolean[21];
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < M; ++i) {
    		String str = br.readLine();
    		
    		if(str.charAt(1) == 'd') {
    			arr[str.charAt(str.length()-1)-'0'] = true;
    		}
    		else if(str.charAt(1) == 'e') {
    			arr[str.charAt(str.length()-1)-'0'] = false;
    		}
    		else if(str.charAt(1) == 'h') {
    			sb.append(arr[str.charAt(str.length()-1)-'0'] ? 1 : 0 ).append("\n");
    		}
    		else if(str.charAt(1) == 'o') {
    			arr[str.charAt(str.length()-1)-'0'] = !arr[str.charAt(str.length()-1)-'0'];
    		}
    		else if(str.charAt(1) == 'l') {
    			Arrays.fill(arr, true);
    		}
    		else {
    			Arrays.fill(arr, false);
    		}
    	}
    	
    	System.out.println(sb);
    }
}