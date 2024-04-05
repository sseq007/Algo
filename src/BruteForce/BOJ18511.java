package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ18511 {

    static int[] sel;
    static int[] arr;
    static int n,k,max=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[k];
        sel = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <=Integer.toString(n).length() ; i++) {
            sel = new int[i];
            recur(0);
        }
        System.out.println(max);

    }

    private static void recur(int idx) {
        if (idx == sel.length) {
//            System.out.println(Arrays.toString(sel));
            String str = "";
            for (int val : sel) {
                str += Integer.toString(val);
            }
            max = Integer.parseInt(str) <= n ? Math.max(max, Integer.parseInt(str)) : max;
            return;
        }

        for (int i = 0; i < k; i++) {
            sel[idx] = arr[i];
            recur(idx+1);
        }
    }
}
