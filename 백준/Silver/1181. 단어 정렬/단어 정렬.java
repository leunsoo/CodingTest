
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int count = Integer.parseInt(br.readLine());
    	String[] strArr = new String[count];
    	
    	for(int i = 0; i < count; ++i)
    	{
    		strArr[i] = br.readLine();
    	}
    	
    	Arrays.sort(strArr, new Comparator<String>() {
    		public int compare(String o1, String o2) {
    			if(o1.length() == o2.length())
    				return o1.compareTo(o2);
    			else {
    				return o1.length() - o2.length();
				}
			}
		});
    	
    	
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append(strArr[0]).append("\n");
    	for(int i = 1; i < strArr.length; ++i)
    	{
    		//중복된 요소가 아닐 경우
    		if(!strArr[i].equals(strArr[i-1]))
    			sb.append(strArr[i]).append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
}
