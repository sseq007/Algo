package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 줄어들지않아 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[65][10];



        for (int i = 0; i <= 9; i++) {
            dp[1][i]=1;
        }

        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            long count = 0;

            for (int i = 0; i < 10; i++) {
                count += dp[n][i];
            }

            System.out.println(count);



        }
    }


}
