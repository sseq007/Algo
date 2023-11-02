package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공통부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input1 = br.readLine();
        String input2 = br.readLine();

        int max = 0;
        int[][] dp = new int[input1.length() + 1][input2.length() + 1];

        for (int i = 1; i <= input1.length(); i++) {
            for (int j = 1; j <= input2.length(); j++) {
                if (input1.charAt(i-1) == input2.charAt(j-1)) {
                    dp[i][j]=dp[i-1][j-1]+1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        System.out.println(max);


    }
}
