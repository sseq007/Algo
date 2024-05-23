package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//공유기 설치
public class BOJ2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = 1, max = arr[n - 1];
        while (min <= max) {

            int mid = (min + max) / 2;
            int count = 1, temp = arr[0];
            for (int i = 1; i < n; i++) {
                if(arr[i]-temp<mid) continue;
                count++;
                temp = arr[i];
            }
            if(count>=c) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(max);
    }
}
