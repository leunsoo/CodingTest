import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드 개수 
        int nodes = Integer.parseInt(br.readLine());
        // 노드 그래프
        HashMap<String,String[]> graph = new HashMap<>();
        String root = "";
        
        // 그래프 그리기
        for(int i = 0; i < nodes; ++i) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            
            String key = stk.nextToken();
            String[] value = new String[2];

            if(i == 0) root = key;
            
        	for(int j = 0; j < 2; ++j )
        	{
        		value[j] = stk.nextToken();
        	}
        	
        	graph.put(key, value);
        }
        

        recursivePrefix(graph, root); System.out.println();
        recursiveInfix(graph, root); System.out.println();
        recursivePostfix(graph, root);
    }

    // 전위
    private static void recursivePrefix(HashMap<String, String[]> graph, String root)
    {
		System.out.print(root);
		
		String[] child = graph.get(root);
		
		if(child[0].equals(".") && child[1].equals("."))
			return;
		
		if(!child[0].equals("."))
			recursivePrefix(graph, child[0]);
		
		if(!child[1].equals("."))
			recursivePrefix(graph, child[1]);
    }
    
    // 중위 
	private static void recursiveInfix(HashMap<String, String[]> graph, String root) 
	{
		String[] child = graph.get(root);
		
		if(!child[0].equals("."))
			recursiveInfix(graph, child[0]);

		System.out.print(root);
		
		if(!child[1].equals("."))
			recursiveInfix(graph, child[1]); 

		if(child[0].equals(".") && child[1].equals("."))
			return;
	}
    
    // 후위 
    private static void recursivePostfix(HashMap<String, String[]> graph, String root)
    {
		String[] child = graph.get(root);

		if(!child[0].equals("."))
			recursivePostfix(graph, child[0]);

		if(!child[1].equals("."))
			recursivePostfix(graph, child[1]);
		
		System.out.print(root);

		if(child[0].equals(".") && child[1].equals("."))
			return;
    }
    
}
