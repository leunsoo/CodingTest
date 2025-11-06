import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String splitStr = br.readLine();
		
		int splitLen = splitStr.length();
		
		ArrayList<Character> lst = new ArrayList<>();
		
		for(int i = 0; i < str.length(); ++i) {
			lst.add(str.charAt(i));
			
			if(lst.size() >= splitLen) {
				boolean isSame = true;
				
				for(int j = 0; j < splitLen; ++j) {
					if(lst.get(lst.size()-splitLen+j) != splitStr.charAt(j)) {
						isSame = false;
						break;
					}
				}
				
				if(isSame) {
					for(int j = 0; j < splitStr.length(); ++j) {
						lst.remove(lst.size()-1);
					}
				}
			}
		}
		
		if(lst.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			for(char c : lst) {
				sb.append(c);
			}
			System.out.println(sb);
		}
	}
}