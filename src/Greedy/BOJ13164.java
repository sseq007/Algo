package Greedy;

import javax.management.MBeanAttributeInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//행복유치원
public class BOJ13164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] diff = new Integer[n - 1];
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <n ; i++) {
            diff[i - 1] = arr[i] - arr[i - 1];
        }
        Arrays.sort(diff, Collections.reverseOrder());
//        System.out.println(Arrays.toString(diff));
        int sum = 0;
        for (int i = k-1; i <n-1 ; i++) {
            sum += diff[i];
        }
        System.out.println(sum);

    }
}
