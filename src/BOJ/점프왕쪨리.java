package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프왕쪨리 {

    static int n;
    static int[][] map;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static boolean[][] v;
    static String result = "Hing";
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
        v = new boolean[n][n];
        v[0][0] = true;
        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int x, int y) {
        if (map[x][y] == -1) {
            result = "HaruHaru";
            return;
        }
        for (int d = 0; d < 2; d++) {
            int nx = x + (dx[d] * map[x][y]);
            int ny = y + (dy[d] * map[x][y]);
            if(nx<0||ny<0||nx>=n||ny>=n) continue;
            if(v[nx][ny]) continue;
            v[nx][ny] = true;
            dfs(nx, ny);
        }
    }
}
