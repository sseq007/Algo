package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//주유소
public class BOJ13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] road = new int[n ];
        int[] price = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n ; i++) {
            if (i == n - 1) {
                road[i] = 0;
                continue;
            }
            road[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        long sum = 0;
        long min = price[0];
        for (int i = 0; i < n; i++) {
            if (price[i] < min) {
                min = price[i];
            }
            sum += min * road[i];
        }
        System.out.println(sum);



    }
}
