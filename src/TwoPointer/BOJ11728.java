package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//두 배열
public class BOJ11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        int[] arrB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        int leftA = 0, leftB = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (leftA == n) {
                for (int i = leftB; i <m ; i++) {
                    sb.append(arrB[i]+" ");
                }
                break;
            }
            if (leftB == m) {
                for (int i = leftA; i <n ; i++) {
                    sb.append(arrA[i]+" ");
                }
                break;
            }

            if (arrA[leftA] < arrB[leftB]) {
                sb.append(arrA[leftA]+" ");
                leftA++;
            } else {
                sb.append(arrB[leftB]+" ");
                leftB++;
            }
        }

        System.out.println(sb);

    }
}
