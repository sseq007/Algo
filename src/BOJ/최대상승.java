package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대상승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            int val = Integer.parseInt(st.nextToken());
            if (i == 0) {
                dp[i][0]=0;
                dp[i][1] = val;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], val - dp[i - 1][1]);
            dp[i][1] = Math.min(dp[i - 1][1], val);
        }
        System.out.println(dp[n-1][0]);
    }
}
