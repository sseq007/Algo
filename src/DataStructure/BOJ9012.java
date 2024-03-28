package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            String result = "YES";
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (stack.isEmpty()) {
                    if (c == '(') {
                        stack.push('(');
                    } else {
                        result = "NO";
                        break;
                    }
                } else {
                    if (stack.peek() == ')') {
                        result = "NO";
                        break;
                    }else{
                        if (c == '(') {
                            stack.push('(');
                        } else {
                            stack.pop();
                        }

                    }
                }
            }
            if (!stack.isEmpty()) {
                result = "NO";
            }

            System.out.println(result);
        }
    }
}
