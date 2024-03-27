package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 보석상자 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int left = 1, right = 0, result = Integer.MAX_VALUE, mid = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(arr[i], right);
        }
        while (left <= right) {
            mid = (left + right) / 2;
            int sum =0;
            for (int val : arr) {
                sum += val / mid;
                if (val % mid != 0) {
                    sum++;
                }
            }
            if (sum > n) {
                left = mid + 1;

            } else {
                right = mid-1;
                result = Math.min(result, mid);
            }
        }
        System.out.println(result);
    }
}
