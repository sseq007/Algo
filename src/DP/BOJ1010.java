package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다리 놓기
public class BOJ1010 {

    static int n,m;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[31][31];
        comb();
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            System.out.println(dp[m][n]);
        }
    }

    private static void comb() {
        for (int i = 1; i <= 30; i++) {
            dp[i][1]=i;
        }
        for (int i = 2; i <= 30; i++) {
            for (int j = 2; j < 30; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
    }
}
