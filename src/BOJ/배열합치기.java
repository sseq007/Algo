package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 배열합치기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrA = new int[n];
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i]=(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i]=(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();

        int leftA = 0,leftB=0;
        while (leftA<n&&leftB<m) {
            if (arrA[leftA] <= arrB[leftB]) {
                sb.append(arrA[leftA] + " ");
                leftA++;
            } else {
                sb.append(arrB[leftB] + " ");
                leftB++;
            }
        }
        if (leftA == n) {
            for (int i = leftB; i < m; i++) {
                sb.append(arrB[i] + " ");
            }
        }
        if (leftB == m) {
            for (int i = leftA; i < n; i++) {
                sb.append(arrA[i] + " ");
            }
        }
//        System.out.println(sb);



    }
}
