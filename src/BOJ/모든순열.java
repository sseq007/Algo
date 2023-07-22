package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 모든순열 {

    static int n;
    static int[] sel;
    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        v = new boolean[n+1];
        sel = new int[n];

        recur(0);

        System.out.println(sb.toString());
    }

    private static void recur(int idx) {

        if (idx == sel.length) {
            for (int i = 0; i < sel.length; i++) {
                sb.append(sel[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {

            if (!v[i]) {
                v[i]=true;
                sel[idx]=i;
                recur(idx+1);
                v[i] = false;
            }
        }
    }


}
