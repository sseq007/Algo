package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 1];
        int[] t = new int[n + 1];
        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            t[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = n; i >=1; i--) {
            if (i + p[i] > n+1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + p[i]] + t[i], dp[i + 1]);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
