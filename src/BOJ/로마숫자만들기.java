package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 로마숫자만들기 {

    static int[] arr = {1, 5, 10, 50};
    static int[] sel;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sel = new int[n];
        set = new HashSet<>();
        comb(0, 0);
        System.out.println(set.size());
    }

    private static void comb(int idx, int s) {
        if (sel.length == idx) {
            int sum = 0;
            for (int i = 0; i <sel.length ; i++) {
                sum += arr[sel[i]];
            }
            set.add(sum);
            return;
        }

        for (int i = s; i < arr.length; i++) {
            sel[idx] = i;
            comb(idx+1,i);
        }
    }
}
