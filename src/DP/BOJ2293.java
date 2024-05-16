package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//동전1
public class BOJ2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
            for (int j = val; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
