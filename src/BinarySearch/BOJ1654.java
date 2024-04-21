package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//랜선 자르기
public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long right = 0;
        int[] arr = new int[n];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }
        long left = 1;
        long result = 0;

        while (left <= right) {
            int cnt = 0;
            long mid = (left + right) / 2;

            for (int val : arr) {
                cnt += val / mid;
            }
            if (cnt >= n) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid-1;
            }
        }
        System.out.println(result);

    }
}
