
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int count = Integer.parseInt(br.readLine());
    	ArrayList<String> strArr = new ArrayList<>();
    	
    	for(int i = 0; i < count; ++i)
    	{
    		String word = br.readLine();
    		
    		if(!strArr.contains(word))
    		{
    			strArr.add(word);
    		}
    	}
    	
    	Collections.sort(strArr, new Comparator<String>() {
    		public int compare(String o1, String o2) {
    			if(o1.length() > o2.length())
    				return 1;
    			else if(o1.length() < o2.length())
    				return -1;
    			else {
    				return o1.compareTo(o2);
				}
			}
		});
    	
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < strArr.size(); ++i)
    	{
    		sb.append(strArr.get(i)).append("\n");
    	}
    	
    	System.out.println(sb.toString());
    }
}
