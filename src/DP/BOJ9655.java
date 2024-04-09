package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//돌게임
public class BOJ9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        System.out.println(n%2==0?"CY":"SK");

    }
}
