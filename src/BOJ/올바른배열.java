package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 올바른배열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int start=0,end=0;
        int min=5;

        while (end < n) {

            if (arr[end] - arr[start] < 5) {
                end++;
                min = Math.min(min, 5 - (end - start));
            } else {
                start++;
            }
        }
        System.out.println(min);



    }
}
