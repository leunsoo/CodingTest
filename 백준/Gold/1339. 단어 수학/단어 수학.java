import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] words = new String[N];
		int maxlength = 0;
		//입력
		for(int i = 0; i < N; ++i) {
			words[i] = br.readLine();
			
			if(maxlength < words[i].length()) maxlength = words[i].length();
		}
		
		//알고리즘
		HashMap<Character, Integer> hashMap = new HashMap<>(); // 알파벳에 숫자를 지정해줄 해쉬맵 
		int[] indexes = new int[N]; // 각 배열의 현재 인덱스를 저장할 배열
		
		int multifly = 1; // 자릿수 계산할 변수 
		for(int i = 0; i < maxlength-1; ++i) 
			multifly *= 10;
		
		while (maxlength > 0) { // 각 알파벳 별 수 계산 
			for(int i = 0; i < N; ++i) {
				if(words[i].length() < maxlength) continue;
				
				char c = words[i].charAt(indexes[i]++);
				
				if(hashMap.containsKey(c)) {  
					hashMap.put(c, hashMap.get(c) + multifly);
				}
				else { 
					hashMap.put(c, multifly);
				}
			}
			
			maxlength--;
			multifly /= 10;
		}
		
		// 큰 숫자부터 9 ~ 0 을 곱해준다. 
		int[] arr = new int[hashMap.size()];
		Iterator<Character> it = hashMap.keySet().iterator();
		int idx = 0;
		while (it.hasNext()) {
			char key = it.next();
			arr[idx++] = hashMap.get(key);
		}
		
		Arrays.sort(arr);

		long answer = 0;
		for(int i = arr.length-1, n = 9; i >= 0; --i, --n) {
			answer += arr[i]*n;
		}
		
		//출력
		System.out.println(answer);
	}
	
}
