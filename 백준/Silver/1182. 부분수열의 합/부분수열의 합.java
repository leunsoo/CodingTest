import java.io.*;
import java.util.*;

public class Main {
	
	private static int count = 0;
	private static int target;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        target = Integer.parseInt(str[1]);
        int[] arr = new int[n];
        
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
        	arr[i] = Integer.parseInt(stk.nextToken());
        }
        
        recursive(arr, 0, 0);
        
        System.out.println(count);
    }
    
    private static void recursive(int[] arr, int idx, int sum) {
        if (idx == arr.length) {
            return;
        }

        for (int i = idx; i < arr.length; ++i) {	
            if (sum + arr[i] == target) {
                count++;
            }
            recursive(arr, i + 1, sum + arr[i]); 
        }
    }
}

