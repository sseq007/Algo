package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스파이 {
    static int n, m,result;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[2][3];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = 0;
        recur(0, 0, -1);
        System.out.println(result);
    }

    private static void recur(int idx, int sum, int pre) {
        if (idx == n) {
            if (sum >= m) {
                result++;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                int next = sum;
                if (pre == j) {
                    next += arr[i][j] / 2;
                } else {
                    next += arr[i][j];
                }
                recur(idx + 1, next, j);

            }
        }
    }
}
