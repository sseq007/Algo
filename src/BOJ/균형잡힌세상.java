package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if(input.equals(".")) break;
            Stack<String> stack = new Stack<>();
            String[] split = input.split("");
            for (String s : split) {
                switch (s) {
                    case ("("):
                    case ("["):
                        stack.push(s);
                        break;
                    case (")"):
                        if (!stack.isEmpty() && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            stack.push(")");

                        }
                        break;
                    case ("]"):
                        if (!stack.isEmpty() && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            stack.push("]");
                        }
                        break;
                }
            }
            if (stack.isEmpty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");

            }
        }
        System.out.println(sb);

    }
}
