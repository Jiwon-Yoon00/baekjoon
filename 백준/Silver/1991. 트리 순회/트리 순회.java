import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static Node[] nodes = new Node[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 26; i++) {
            nodes[i] = new Node((char)('A' + i));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left   = st.nextToken().charAt(0);
            char right  = st.nextToken().charAt(0);

            Node p = nodes[parent - 'A'];
            if (left != '.')  p.left  = nodes[left - 'A'];
            if (right != '.') p.right = nodes[right - 'A'];
        }

        Node root = nodes[0]; // A
        preorder(root); sb.append('\n');
        inorder(root);  sb.append('\n');
        postorder(root);

        System.out.print(sb);
    }

    static void preorder(Node node) {
        if (node == null) return;
        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    static class Node {
        char value;
        Node left, right;
        Node(char value) {
            this.value = value;
        }
    }
}
