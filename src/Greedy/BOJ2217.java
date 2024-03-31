package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;


public class BOJ2217 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int max_weight = arr[0];
//        System.out.println(max_weight);
        for (int i = 1; i < n; i++) {
            max_weight = Math.max(max_weight, arr[i] * (i+1));
        }
        System.out.println(max_weight);



    }
}
