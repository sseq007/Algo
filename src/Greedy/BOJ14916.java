package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int none = Integer.MAX_VALUE;
        int[] dp = new int[n+1+6];
        dp[1]=none;
        dp[2]=1;
        dp[3]=none;
        dp[4]=2;
        dp[5]=1;

        for (int i = 6; i <= n; i++) {
            dp[i]=Math.min(dp[i-2],dp[i-5])+1;
        }
        System.out.println(dp[n]==none?-1:dp[n]);


    }
}
