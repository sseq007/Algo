package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//로또
public class BOJ6603 {

    static int k;
    static int[] arr;
    static int[] sel;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if(input.equals("0")) break;
            StringTokenizer st = new StringTokenizer(input);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            sel = new int[6];
            comb(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void comb(int idx, int s) {

        if (idx == sel.length) {
//            System.out.println(Arrays.toString(sel));
//            Arrays.sort(sel);
            for (int val : sel) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = s; i < k; i++) {
            sel[idx] = arr[i];
            comb(idx + 1, i + 1);
        }
    }
}
