
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	int a = Integer.parseInt(stk.nextToken());
    	int b = Integer.parseInt(stk.nextToken());
    	
    	int gcd = gcd(a, b);
    	System.out.printf("%d\n%d",gcd, a*b/gcd);
    }
    
    private static int gcd(int a, int b)
    {
    	if(a%b == 0) return b;
    	
    	return gcd(b, a%b);
    }
}
