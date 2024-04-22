package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬만들기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = input.length();
        for (int i = 0; i < input.length(); i++) {
            if (check(input.substring(i))) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }

    private static boolean check(String str) {
        int start = 0, end = str.length() - 1;

        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
