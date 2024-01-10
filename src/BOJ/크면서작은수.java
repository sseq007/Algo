package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 크면서작은수 {


    static int[] nums,sel;
    static boolean[] v;
    static int n,val,min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        val = Integer.parseInt(input);
        n = input.length();
        sel = new int[n];
        nums = new int[n];
        v = new boolean[n];
        for (int i = 0; i < input.length(); i++) {
            nums[i] = input.charAt(i) - '0';
        }


        recur(0);
        System.out.println(min==Integer.MAX_VALUE?0:min);


    }

    private static void recur(int idx) {
        if (idx == n) {
            System.out.println(Arrays.toString(sel));
            String str = "";
            for (int num : sel ) {
                str += Integer.toString(num);
            }

            int num = Integer.parseInt(str);
            if (val < num) {
                min = Math.min(min, num);
            }
            return;
        }
        for (int i = 0; i < n;i++) {
            if (!v[i]) {
                v[i] = true;
                sel[idx] = nums[i];
                recur(idx + 1);
                v[i]=false;
            }
        }
    }
}
