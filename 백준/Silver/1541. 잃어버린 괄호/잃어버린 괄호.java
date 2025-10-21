import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strs = br.readLine().split("-");
    	
    	int[] arr = new int[strs.length];
    	
    	for(int i = 0; i < strs.length; ++i) {
    		String str = strs[i];
    			
    		String[] strs_sub = str.split("\\+");
    		
    		int sum = 0;
    		for(int j = 0; j < strs_sub.length; ++j) {
    			sum += Integer.parseInt(strs_sub[j]);
    		}
    		arr[i] = sum;
    	}
    	
    	int ans = arr[0];
    	for(int i = 1; i < arr.length; ++i) {
    		ans -= arr[i];
    	}
    	System.out.println(ans);
    }
}