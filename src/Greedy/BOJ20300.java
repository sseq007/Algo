package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//서강근육맨
public class BOJ20300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long min = 0;
        if (arr.length % 2 == 0) {
            for (int i = 0; i < arr.length / 2; i++) {
                min = Math.max(min, arr[i] + arr[n - i - 1]);
            }
        } else {

            min = arr[n - 1];
            for (int i = 0; i < n / 2; i++) {
                min = Math.max(min, arr[i] + arr[n - i - 2]);
            }
        }
        System.out.println(min);
    }
}
