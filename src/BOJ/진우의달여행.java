package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 진우의달여행 {
    static int n, m,min=Integer.MAX_VALUE;
    static int[][] map;
    static int[] v;
    static int[] dy = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            v = new int[n];
            v[0] = i;
            dfs(1, i, -1);

        }


        System.out.println(min);

    }

    private static void dfs(int idx, int y, int dir) {
        if (idx == n) {
            int sum = map[0][v[0]];
            for (int i = 1; i < n; i++) {
                sum += map[i][v[i]];
            }
            min = Math.min(sum, min);


            return;
        }
        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            if (isBoundary(ny) && dir != d) {
                v[idx]=ny;
                dfs(idx + 1, ny, d);
            }
        }
    }

    private static boolean isBoundary(int ny) {
        if (0 > ny || ny >= m) {

            return false;
        }
        return true;
    }
}
