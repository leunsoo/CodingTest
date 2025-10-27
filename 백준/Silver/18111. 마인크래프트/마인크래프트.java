import java.io.*;
import java.util.*;

public class Main {
	static int N, M, B;
	static int[][] arr;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(stk.nextToken());
    	M = Integer.parseInt(stk.nextToken());
    	B = Integer.parseInt(stk.nextToken());
    	
    	arr = new int[N][M];
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < N; ++i) {
    		stk = new StringTokenizer(br.readLine());
    		for(int j = 0; j < M; ++j) {
    			int height = Integer.parseInt(stk.nextToken()); 
    			arr[i][j] = height;
    			min = Math.min(height, min);
    			max = Math.max(height, max);
    		}
    	}
    	
    	int minTime = Integer.MAX_VALUE;
    	int highest = Integer.MIN_VALUE;
    	for(int i = min; i <= max; ++i) {
    		int time = checkGround(i);
    		if(time <= minTime) {
    			minTime = time;
    			highest = i;
    		}
    	}
    	
    	System.out.println(minTime + " " + highest);
	}
    
    private static int checkGround(int targetHeight) {
    	int inventory = B;
    	int time = 0;
    	
    	for(int i = 0; i < N; ++i) {
    		for(int j = 0; j < M; ++j) {
    			int diff = arr[i][j] - targetHeight;
    			
    			if(diff > 0) {
    				time += diff * 2;
    				inventory += diff;
    			}
    			else if(diff < 0) {
    				time -= diff;
    				inventory += diff;
    			}
    		}
    	}
    	
    	if(inventory < 0) {
    		return Integer.MAX_VALUE;
    	}
    	
    	return time;
    }
}