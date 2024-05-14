package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//개똥벌레
public class BOJ3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] sumU = new int[h + 2];
        int[] sumD = new int[h + 2];
        for (int i = 0; i < n / 2; i++) {
            sumD[Integer.parseInt(br.readLine())]++;
            sumU[h-Integer.parseInt(br.readLine())+1]++;
        }
        for (int i = 1; i <= h; i++) {
            sumD[i] += sumD[i - 1];
//            sumU[i] += sumU[i - 1];


        }
        for (int i = h; i >=1 ; i--) {
            sumU[i]+=sumU[i+1];
        }
//        System.out.println(Arrays.toString(sumD));
//        System.out.println(Arrays.toString(sumU));
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int d = sumD[h] - sumD[i - 1];
//            int u = sumU[h] - sumU[i - 1];
            int u = sumU[1] - sumU[i + 1];
            if (min > d + u) {
                min = d + u;
                cnt = 1;
            } else if (min == d + u) {
                cnt++;
            }
        }
        System.out.printf("%d %d\n",min,cnt);
    }
}
