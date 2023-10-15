package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//boj 2504
public class 괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int sum = 0;
        int val =1;
        for (int i = 0; i < input.length(); i++) {
            //( 일때
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
                val*=2;
            }
            //)일떄
            else if (input.charAt(i) == ')') {
                if (stack.isEmpty()||stack.peek() != '('  ) {
                    sum=0;
                    break;
                } else if (input.charAt(i - 1) == '(') {
                    sum+=val;
                }
                stack.pop();
                val/=2;
            }

            //[일때
            else if (input.charAt(i) == '[') {
                stack.push(input.charAt(i));
                val*=3;
            }

            //]일떄
            else if (input.charAt(i) == ']') {
                if (stack.isEmpty()||stack.peek() != '[') {
                    sum=0;
                    break;
                } else if (input.charAt(i - 1) == '[') {
                    sum+=val;
                }
                stack.pop();
                val/=3;
            }

        }
        System.out.println(!stack.isEmpty()?0:sum);
    }
}
