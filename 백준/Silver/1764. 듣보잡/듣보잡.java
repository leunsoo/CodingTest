import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strs = br.readLine().split(" ");
    	int N = Integer.parseInt(strs[0]);
    	int M = Integer.parseInt(strs[1]);
    	Set<String> set = new HashSet<>();
    	
    	for(int i = 0; i < N; ++i) {
    		set.add(br.readLine());
    	}
    	
    	List<String> lst = new ArrayList<>(); 
    	for(int i = 0; i < M; ++i) {
    		String str = br.readLine();
    		if(set.contains(str)) {
    			lst.add(str);
    		}
    	}
    	
    	Collections.sort(lst);
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append(lst.size()).append("\n");
    	for(int i = 0; i < lst.size(); ++i) {
    		sb.append(lst.get(i)).append("\n");
    	}
    	System.out.println(sb);
    }
}