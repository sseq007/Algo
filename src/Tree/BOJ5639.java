package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//이진 검색 트리
public class BOJ5639 {

    static class Node{
        int num;
        Node left;
        Node right;
        public Node(int num) {
            this.num = num;
            this.left = null;
            this.right = null;
        }
    }
    static Node node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if(input==null||input.equals("")) break;
//            System.out.println(input);
            Node newNode = new Node(Integer.parseInt(input));
            connection(node, newNode);
        }
//        System.out.println("111");
        postOrder(node);




    }

    private static void postOrder(Node node) {
//        if(node == null) return;
        if(node.left !=null) postOrder(node.left);
        if(node.right!=null) postOrder(node.right);
        System.out.println(node.num);
    }

    private static void connection(Node now, Node next) {

        if (now.num > next.num) {
            if (now.left == null) {
                now.left = next;
            } else {
                connection(now.left,next);
            }


        } else {
            if (now.right == null) {
                now.right = next;
            } else {
                connection(now.right, next);
            }
        }
    }
}
