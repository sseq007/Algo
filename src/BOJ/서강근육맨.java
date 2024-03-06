package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강근육맨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long max = 0;

        if (arr.length % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                long sum = arr[i] + arr[n - i - 1];
                max = Math.max(max, sum);
            }

        } else {
            max = arr[n - 1];
            for (int i = 0; i < n / 2; i++) {
                long sum = arr[i] + arr[n - i - 2];
                max = Math.max(max, sum);
            }

        }
        System.out.println(max);

    }
}
