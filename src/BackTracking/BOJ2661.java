package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//좋은 수열
public class BOJ2661 {

    static int n;
    static char[] arr = {'1', '2', '3'};
//    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(0,"");
//        System.out.println(min);
    }

    private static void dfs(int idx,String sum) {
        if (idx == n) {
            System.out.println(sum);
            System.exit(0);

            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!check(sum + arr[i])) {
                dfs(idx + 1, sum + arr[i]);
            }
        }
    }

    private static boolean check(String sum) {
        int len = sum.length();

        for (int i = 1; i <= len / 2; i++) {
            String left = sum.substring(len - (i * 2), len - i);
            String right = sum.substring(len - i, len);
            if (left.equals(right)) {
                return true;
            }
        }
        return false;
    }
}
