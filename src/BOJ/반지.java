package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 반지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            input += input.substring(0, input.length() - 1);
            if (input.contains(str)) {
                result++;
            }
        }
        System.out.println(result);
    }
}
