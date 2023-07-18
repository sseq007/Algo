package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 싫은데요 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start=0,end=0,sum=0,max=0;

        while (end < n) {

            if (sum + arr[end] < m) {
                sum += arr[end];
                end++;
                max = Math.max(sum, max);
            } else {
                sum -= arr[start];
                start++;
            }
            if (start > end) {
                sum += arr[end];
                end++;
            }
        }
        System.out.println(max);
    }
}
