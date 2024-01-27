package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(arr[i], high);
        }
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;

            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += Math.abs(arr[i]-mid);
                }
            }


            if (sum < m) {
                high = mid-1;
            } else {
                low = mid + 1;
            }
                    }
        System.out.println(low-1);


    }
}
