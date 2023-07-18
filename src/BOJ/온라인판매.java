package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 온라인판매 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] price = new int[m];


        for (int i = 0; i < m; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(price);

        int eggPrice = 0;
        int egg=0;
        int max=0;
        int max_n=0;
        for (int i = 0; i < m; i++) {
            egg = price[i];
            eggPrice=0;
            if (m - i < n) {
                eggPrice = egg * (m - i);
            } else {
                eggPrice = egg * n;
            }
            if (max < eggPrice) {
                max = eggPrice;
                max_n=egg;
            }

        }
        System.out.println(max_n+" "+max);
    }
}
