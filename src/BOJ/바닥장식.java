package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 바닥장식 {

    static int n,m,cnt;
    static char[][] map;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        v = new boolean[n][m];
        cnt=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        
    }

    static int[] dx = {0,1};
    static int[] dy = {1,0};

    private static void dfs(int x, int y) {
        v[x][y] = true;
        if (map[x][y] == '-') {
            int nx = x + dx[0];
            int ny = y + dy[0];
            if (ny<m&&map[nx][ny] == '-') {
                dfs(nx, ny);
            }
        } else {
            int nx = x + dx[1];
            int ny = y + dy[1];
            if (nx<n&&map[nx][ny] == '|') {
                dfs(nx,ny);
            }
        }
    }
}
