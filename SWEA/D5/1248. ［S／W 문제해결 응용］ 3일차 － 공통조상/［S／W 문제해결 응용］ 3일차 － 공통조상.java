import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BasicBinaryTree<Integer> myTree = new BasicBinaryTree<Integer>();
 
    static int subRootId;
    static int subTreeSize;
    static int node_01;
    static int node_02;
 
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; ++tc) {
            makeGraph();
            getSubtreeSize();
            print(tc);
        }
    }
 
    public static void makeGraph() throws Exception {
        String[] strs = br.readLine().trim().split(" ");
        int lineCnt = Integer.parseInt(strs[1]);
        node_01 = Integer.parseInt(strs[2]);
        node_02 = Integer.parseInt(strs[3]);
 
        myTree.clear();
        StringTokenizer stk = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < lineCnt; ++i) {
            int parent = Integer.parseInt(stk.nextToken());
            int child = Integer.parseInt(stk.nextToken());
 
            myTree.Add(parent, child);
        }
 
    }
 
    public static void getSubtreeSize() {
        subRootId = myTree.getCommonParentId(node_01, node_02);
        subTreeSize = myTree.getSubtreeSize(subRootId);
    }
 
    public static void print(int tc) {
        System.out.println("#" + tc + " " + subRootId + " " + subTreeSize);
    }
}
 
class BasicBinaryTree<T> {
    private static class Node<T> {
        T id;
        Node<T> parent, left, right; // 부모, 왼자, 오
        int depth; // 노드의 깊이
 
        public Node(T data) {
            this.id = data;
        }
 
        public void setParent(Node<T> parent) {
            this.parent = parent;
            this.depth = parent.depth + 1;
            updateChildDepth(this, depth);
        }
         
        //부모가 생길 시 자기 자식들의 깊이도 조정해줘야한다. - 재귀 활용
        private void updateChildDepth(Node<T> node, int depth) {
            if(node == null) return;
            node.depth = depth;
            updateChildDepth(node.left, depth+1);
            updateChildDepth(node.right, depth+1);
        }
    }
 
    private Map<T, Node<T>> nodes = new HashMap<>();
 
    //공통 부모 찾기 알고리즘
    public T getCommonParentId(T node_1, T node_2) {
        // 두 노드를 검색 한다.
        Node<T> node1 = nodes.get(node_1);
        Node<T> node2 = nodes.get(node_2);
 
        // 두깊이를 비교한다.
        while (!node1.parent.equals(node2.parent)) { // 부모가 다르다면
            // 한쪽의 깊이가 더 낮다면, 해당 노드의 부모로 탐색 대상을 교체한다.
            if (node1.depth > node2.depth) {
                node1 = node1.parent;
            } else if (node1.depth < node2.depth) {
                node2 = node2.parent;
            } else {
                // 둘의 노드의 깊이가 같다면, 부모의 노드를 비교 한다.
                // 다르다면 해당 노드들의 부모 노드로 탐색 대상을 교체한다.
                node1 = node1.parent;
                node2 = node2.parent;
            }
        }
 
        return node1.parent.id; // 공통 부모 반환
    }
 
    //서브트리의 사이즈 반환 - Bfs 활용
    public int getSubtreeSize(T subRootId) {
        Node<T> curr = nodes.get(subRootId);
        int nodeCnt = 0;
 
        MyQueue<Node<T>> queue = new MyQueue<Node<T>>();
        queue.add(curr);
 
        while (!queue.isEmpty()) {
            curr = queue.poll();
            nodeCnt++;
 
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
 
        return nodeCnt; 
    }
 
    // 삽입
    public void Add(T parentId, T childId) {
        Node<T> parent = nodes.get(parentId);
 
        if (parent == null) {
            parent = new Node<T>(parentId);
            nodes.put(parentId, parent);
        }
 
        Node<T> child = nodes.get(childId);
        if(child == null) {
            child = new Node<T>(childId);
            nodes.put(childId, child);
        }
 
        // 왼쪽 자식 노드가 없을 경우 왼쪽 자식부터
        if (parent.left == null) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        child.setParent(parent);
    }
 
    public void clear() {
        nodes.clear();
    }
}
 
//선입 선출
class MyQueue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
 
        public Node(T data) {
            this.data = data;
            next = null;
        }
    }
 
    Node<T> head;
    Node<T> tail;
    int size;
 
    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }
 
// 뒤에 추가
    public void add(T data) {
        Node<T> node = new Node<T>(data);
 
        if (isEmpty()) {
            head = node;
            tail = node;
            size++;
            return;
        } else if (size == 1) {
            head.next = node;
            tail = node;
            size++;
            return;
        }
 
        size++;
        tail.next = node;
        tail = node;
    }
 
//head의 데이터 반환
    public T peek() {
        if (isEmpty())
            return null;
 
        return head.data;
    }
 
// 삭제 및 데이터 반환
    public T poll() {
        if (isEmpty())
            return null;
 
        T data = head.data;
        size--;
        if (isEmpty()) {
            head = tail = null;
        } else if (size == 1) {
            head = tail;
            head.next = null;
        } else {
            head = head.next;
        }
 
        return data;
    }
 
    public int size() {
        return size;
    }
 
    public boolean isEmpty() {
        return size == 0;
    }
}