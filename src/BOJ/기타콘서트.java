package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 기타콘서트 {

    static int n,m,min=Integer.MAX_VALUE,max = 0;
    static int[][] gitar;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        gitar = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String can = st.nextToken();
            for (int j = 0; j < m; j++) {
                if (can.charAt(j) == 'Y') {
                    gitar[i][j]=1;
                }
            }
        }
        v = new boolean[n];
        powerset(0);
        System.out.println(min==0?-1:min);

    }

    private static void powerset(int idx) {
        if (idx == v.length) {
            boolean[] sum = new boolean[m];
            int cnt = 0;
            for (int i = 0; i < v.length; i++) {
                if (v[i]) {
                    for (int j = 0; j < m; j++) {
                        if (gitar[i][j] == 1) {
                            sum[j] = true;
                        }
                    }
                    cnt++;
                }
            }
            int check = check(sum);
            if (check >= max) {
                min = Math.min(min, cnt);
                max = check;
            }


            return;
        }
        v[idx] = true;
        powerset(idx+1);
        v[idx] = false;
        powerset(idx+1);

    }

    private static int check(boolean[] sum) {
        int cnt = 0;
        for (boolean flag : sum) {
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }
}
