package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//선발 명단
public class boj3980 {

    static int[][] map;
    static boolean[] v;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            map = new int[11][11];
            v = new boolean[11];
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            dfs(0, 0);
            System.out.println(max);
        }
    }

    private static void dfs(int idx, int total) {
        if (idx == 11) {
            max = Math.max(max, total);
            return;
        }
        for (int i = 0; i < 11; i++) {
            if (!v[i] && map[idx][i] != 0) {
                v[i] = true;
                dfs(idx + 1, map[idx][i] + total);
                v[i]=false;
            }
        }

    }
}
