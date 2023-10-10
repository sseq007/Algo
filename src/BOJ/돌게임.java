package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[n+1];

        if(n==2){
            dp[2]=true;
        }
        for (int i = 4; i <=n ; i++) {
            dp[i] = !dp[i - 1];
        }

        System.out.println(!dp[n]?"SK":"CY");
    }
}
