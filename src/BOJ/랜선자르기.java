package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 랜선자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long max_length = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max_length = Math.max(max_length, arr[i]);
        }
        long min = 1;
        long half = 0;

        while (true) {
            if(min>max_length) break;
            int cnt=0;

            half = (min+max_length)/2;

            for (int val : arr) {
                cnt += val / half;
            }

            if (cnt >= n) {
                min = half+1;
            } else {
                max_length = half - 1;
            }

        }
        System.out.println((max_length+min)/2);

    }
}