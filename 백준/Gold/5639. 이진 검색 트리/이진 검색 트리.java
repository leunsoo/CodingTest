import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> preOrder = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            preOrder.add(Integer.parseInt(line));
        }

        if (preOrder.isEmpty()) return;

        Node root = new Node(preOrder.get(0));

        for (int i = 1; i < preOrder.size(); i++) {
            insert(root, preOrder.get(i));
        }

        postOrder(root);

        System.out.print(sb);
    }

    private static void insert(Node root, int val) {
        if (val < root.val) {
            if (root.left == null) root.left = new Node(val);
            else insert(root.left, val);
        } else {
            if (root.right == null) root.right = new Node(val);
            else insert(root.right, val);
        }
    }

    // 후위 순회
    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.val).append('\n');
    }
}
