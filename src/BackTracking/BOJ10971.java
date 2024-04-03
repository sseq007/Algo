package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//외판원 순회 2
public class BOJ10971 {

    static int n,min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[]v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            v = new boolean[n];
            v[i] = true;
            dfs(i, i, 0);
        }

        System.out.println(min);
    }

    private static void dfs(int start, int now, int cost) {

        if (allVisited()) {
            if (map[now][start] != 0) {
                min = Math.min(min, cost+map[now][start]);
            }

            return;
        }


        for (int i = 0; i < n; i++) {
            if (!v[i] && map[now][i] != 0) {

                v[i] = true;
                dfs(start, i, cost + map[now][i]);
                v[i]=false;

            }
        }
    }

    private static boolean allVisited() {
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                return false;
            }
        }
        return true;
    }

}
