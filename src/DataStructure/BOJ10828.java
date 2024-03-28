package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else {
                switch (order) {
                    case "pop":
                        System.out.println(stack.isEmpty()?"-1":stack.pop());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.isEmpty() ? "1" : "0");
                        break;
                    case "top":
                        System.out.println(stack.isEmpty() ? "-1" : stack.peek());
                        break;
                }
            }
        }
    }
}
