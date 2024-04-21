package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//나무 자르기
public class BOJ2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int left = 1, right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i], right);
        }
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int val : arr) {
                if (val > mid) {
                    sum += val - mid;

                }
            }
            if (sum >= m) {
                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                right = mid-1;
            }
        }
        System.out.println(result);
    }
}
