import java.io.*;
import java.util.*;

public class Main {
	static char[][] board;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strs = br.readLine().split(" ");
    	int N = Integer.parseInt(strs[0]);
    	int M = Integer.parseInt(strs[1]);
    	
    	board = new char[N][M];
    	for(int i = 0; i < N; ++i) {
    		String str = br.readLine();
    		for(int j = 0; j < M; ++j) {
    			board[i][j] = str.charAt(j);
    		}
    	}
    	
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i <= N-8; ++i) {
    		for(int j = 0; j <= M-8; ++j) {
    			min = Math.min(min, search(i, j, 'W'));
    			min = Math.min(min, search(i, j, 'B'));
    		}
    	}
    	
    	System.out.println(min);
    }
    
    private static int search(int r, int c , char color) {
    	int paintCnt = 0;
    	for(int i = r; i < r + 8; ++i) {
    		for(int j = c; j < c + 8; ++j) {
    			if(i%2 == 0 && j%2 == 0) {
    				if(board[i][j] != color) paintCnt++;
    			}
    			else if(i%2 == 1 && j%2 == 1 ) {
    				if(board[i][j] != color) paintCnt++;
    			}
    			else if(board[i][j] == color) 
    				paintCnt++;
    		}
    	}
    	return paintCnt;
    }
}