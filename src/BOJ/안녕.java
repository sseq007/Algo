package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안녕 {

    static int n;
    static int[][] dp;
    static int[] minusPower;
    static int[] plusPower;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int k = 99;
        dp = new int[n+1][k+1];
        minusPower= new int[n+1];
        plusPower = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            minusPower[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            plusPower[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=k; j++) {
                if (minusPower[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - minusPower[i]] + plusPower[i]);
                } else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}
