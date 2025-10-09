import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr_2 = new int[N]; // 2번을 위한 배열
    	int[] arr_3 = new int[8002]; // 3번을 위한 배열
    	Map<Integer, ArrayList<Integer>> hm_3 = new HashMap<Integer, ArrayList<Integer>>(); // 3번을 위한 맵
    	
    	int max = Integer.MIN_VALUE; // 4번을 위한 변수
    	int min = Integer.MAX_VALUE; // 4번을 위한 변수
    	int sum = 0; // 1번을 위한 편수
    	
    	for(int i = 0; i < N; ++i) {
    		int num = Integer.parseInt(br.readLine());
    		
    		arr_2[i] = num;
    		arr_3[num+4000]++;
    		
    		sum += num;
    		
    		if(max < num) max = num;
    		if(min > num) min = num;
    	}
    	
    	Arrays.sort(arr_2);
    	
    	for(int i = 0; i < 8002; ++i) {
    		if(hm_3.get(arr_3[i]) == null) {
    			hm_3.put(arr_3[i], new ArrayList<Integer>());
    		}
    		hm_3.get(arr_3[i]).add(i-4000);
    	}
    	
    	Arrays.sort(arr_3);
    	ArrayList<Integer> al = hm_3.get(arr_3[8001]);
    	int answer_3 = al.size() > 1 ? al.get(1) : al.get(0);
    	
    	System.out.println(Math.round(sum/(float)N));
    	System.out.println(arr_2[N/2]);
    	System.out.println(answer_3);
    	System.out.println(max-min);
    }
}