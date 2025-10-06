import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for(int i = 0; i < n; ++i) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        int slice = Math.round(n*15/100f);
        Arrays.sort(arr);
        
        int sum = 0;
        for(int i = slice; i < n-slice; ++i) {
        	sum += arr[i];
        }
        System.out.println(Math.round(sum/(float)(n-2*slice)));
    }
}