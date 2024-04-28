package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//단어 뒤집기 2
public class BOJ17413 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {

                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
                sb.append(input.charAt(i));
                continue;
            }
            if (input.charAt(i) == '>') {
                flag = false;
                sb.append(input.charAt(i));
                continue;
            }
            if (flag) {
                sb.append(input.charAt(i));
            } else {
                if (input.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                    continue;
                } else {
                    stack.push(input.charAt(i));
                }
            }
            if (i == input.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }


        }
        System.out.println(sb);
    }
}
