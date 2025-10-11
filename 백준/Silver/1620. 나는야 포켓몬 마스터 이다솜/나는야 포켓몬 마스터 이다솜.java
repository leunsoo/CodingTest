import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strs = br.readLine().split(" ");
    	int N = Integer.parseInt(strs[0]);
    	int M = Integer.parseInt(strs[1]);
    	HashMap<Integer, String> int_string = new HashMap<>();
    	HashMap<String, Integer> string_int = new HashMap<>();
    	
    	
    	for(int i = 1; i <= N; ++i) {
    		String p = br.readLine();
    		int_string.put(i, p);
    		string_int.put(p, i);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < M; ++i) {
    		String str = br.readLine();
    		try {
				sb.append(int_string.get(Integer.parseInt(str))).append("\n");
			} catch (Exception e) {
				sb.append(string_int.get(str)).append("\n");
			}
    	}
    	System.out.println(sb);
    }
}