package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//조합
public class BOJ2407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        BigInteger[][] dp = new BigInteger[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = new BigInteger(Integer.toString(i));
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <=n ; j++) {
                dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
            }
        }
        System.out.println(dp[m][n]);
    }
}
