package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> sum = new Stack<>();
        boolean flag = false;
        boolean close = false;
        int result =0,answer=0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(' || c == '[') {
                if (close) {
                    while (!sum.isEmpty()) {
//                        answer += sum.pee();
                    }
//                    result += sum.pop();

                    close = false;
                }
                stack.push(c);

            } else {
                if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                    if (!close) {
                        sum.push(2);
                    } else {
                        result = (sum.pop() * 2);
                        System.out.println(result);
                        sum.push(result);
                    }
                    close = true;

                    stack.pop();

                } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                    if (!close) {
                        sum.push(3);
                    } else {
                        result = (sum.pop() * 3);
                        System.out.println(result);
                        sum.push(result);
                    }
                    close = true;
                    stack.pop();

                } else {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(flag?"0":answer);
    }


}
