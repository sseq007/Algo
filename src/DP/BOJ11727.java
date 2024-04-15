package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2*n 타일링 2
public class BOJ11727 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1]=1;
        for (int i = 2; i < 1001; i++) {
            if (i % 2 == 0) {
                dp[i] = ((dp[i - 1] * 2) + 1) % 10007;

            } else {
                dp[i] = ((dp[i - 1] * 2) - 1) % 10007;
            }

        }
        System.out.println(dp[n]);
    }
}
