package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창영이와점프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] distance = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[2][n];
        dp[0][0]=1;
        dp[1][0]=1;

        int result=0;
        for (int i = 1; i < n; i++) {
            //이동 가능할 때
            if (k >= distance[i]) {
                dp[0][i]=dp[0][i-1]+1;
                dp[1][i]=dp[1][i-1]+1;
            }else{
                dp[0][i]=1;
                dp[1][i] = Math.max(dp[0][i - 1] + 1, 1);
            }
            result = Math.max(result, Math.max(dp[0][i], dp[1][i]));

        }
        System.out.println(result);


    }
}
