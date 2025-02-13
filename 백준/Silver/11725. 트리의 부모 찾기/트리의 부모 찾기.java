import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<Integer, ArrayList<Integer>> nodemap = new HashMap<>();
    private static ArrayList<Integer> nodeList;
    private static int[] answers;
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int count = Integer.parseInt(br.readLine());
    	answers = new int[count+1];
    	visited = new boolean[count+1];
    	
    	//트리 구하기
    	for(int i = 0; i < count-1; ++i)
    	{
    		String[] nodes = br.readLine().split(" ");
    		int lNode = Integer.parseInt(nodes[0]);
    		int rNode = Integer.parseInt(nodes[1]);
    		
    		if(nodemap.containsKey(lNode))
			{
				nodemap.get(lNode).add(rNode);
			}
			else {
				nodemap.put(lNode, new ArrayList<Integer>());
				nodemap.get(lNode).add(rNode);
			}

    		if(nodemap.containsKey(rNode))
			{
				nodemap.get(rNode).add(lNode);
			}
			else {
				nodemap.put(rNode, new ArrayList<Integer>());
				nodemap.get(rNode).add(lNode);
			}
    	}
    	
    	recusive(1);
    	
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	for (int i = 2; i < answers.length; ++i) {
			bw.write(answers[i]+"\n");
		}
    	bw.flush();
    	bw.close();
    	
    }
    
    private static void recusive(int pNode)
    {
		visited[pNode] = true;
    	nodeList = nodemap.get(pNode);
    	
    	if(nodeList.size() == 1 && visited[nodeList.get(0)])
    	{
    		if(answers[nodeList.get(0)] == 0)
    			answers[nodeList.get(0)] = pNode;
    		
    		return;
    	}
    	
    	for (int node : nodeList) {
    		if(answers[node] != 0 && visited[pNode]) continue;
    		
    		answers[node] = pNode;
    		recusive(node);
		}
    	
    }
}