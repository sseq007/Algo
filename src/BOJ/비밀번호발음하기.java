package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 비밀번호발음하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            char[] charArray = input.toCharArray();
            boolean flag = false;
            int count = 0;
            char prev = ',';
            for (char c : charArray) {
                if (check(c)) {
                    flag = true;
                }
                if(check(c)!=check(prev)) count=1;
                else count++;
                if (count > 2 || prev == c && (c != 'e' && c != 'o')) {
                    flag = false;
                    break;
                }
                prev = c;

            }
            StringBuilder sb = new StringBuilder();
            if (flag) {
                sb.append("<").append(input).append("> is acceptable.");
            } else {
                sb.append("<").append(input).append("> is not acceptable.");

            }
            System.out.println(sb);
        }
    }

    private static boolean check(char c) {
        if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i') {
            return true;
        }
        return false;
    }
}
