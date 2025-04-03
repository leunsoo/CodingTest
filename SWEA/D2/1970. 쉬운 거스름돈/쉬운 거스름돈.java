import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        int[] arr = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
        
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; ++tc) {
            sb.append("#").append(tc).append("\n");
            
            int money = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < arr.length; ++i) {
            	int div = money / arr[i];
				money -= div*arr[i];
				sb.append(div).append(" ");
            }
             
            sb.append("\n");
        }   
         
        System.out.println(sb.toString());
    }
}