import java.io.*;
import java.util.*;

class Node {
    char node;
    Node left, right;

    public Node(char value) {
        node = value;
        left = null;
        right = null;
    }

    public char getValue() {
        return node;
    }
}

public class Main {
    public static int N;
    public static Node[] tree;
    public static StringBuilder sb = new StringBuilder();

    public static void preOrder(Node node) {
        if (node == null)
            return;
        sb.append(node.getValue());
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        sb.append(node.getValue());
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.getValue());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parents = st.nextToken().toCharArray()[0];
            char leftChild = st.nextToken().toCharArray()[0];
            char rightChild = st.nextToken().toCharArray()[0];

            if (tree[parents - 'A'] == null)
                tree[parents - 'A'] = new Node(parents);

            if (leftChild != '.') {
                tree[leftChild - 'A'] = new Node(leftChild);
                tree[parents - 'A'].left = tree[leftChild - 'A'];
            }

            if (rightChild != '.') {
                tree[rightChild - 'A'] = new Node(rightChild);
                tree[parents - 'A'].right = tree[rightChild - 'A'];
            }

        }

        preOrder(tree[0]);
        sb.append("\n");

        inOrder(tree[0]);
        sb.append("\n");

        postOrder(tree[0]);
        sb.append("\n");

        System.out.println(sb.toString());

    }

}