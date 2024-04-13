package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {

    static class Node{
        char val;
        Node left;
        Node right;
        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }
            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }
            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }
        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
    }

    private static void postorder(Node node) {
        if(node== null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.val);
    }

    private static void inorder(Node node) {
        if(node==null) return;
        inorder(node.left);
        System.out.print(node.val);
        inorder(node.right);
    }

    private static void preorder(Node node) {
        if(node==null) return;
        System.out.print(node.val);
        preorder(node.left);
        preorder(node.right);

    }
}
