package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17836 {

    static class Point{
        int x,y,time;
        int flag;
        public Point(int x, int y, int time, int flag) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.flag = flag;
        }
    }
    static int n,m,t,min = Integer.MAX_VALUE;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);
        System.out.println(min>t?"Fail":min);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        boolean[][][] v = new boolean[n][m][2];
        q.add(new Point(x, y, 0, 0));
        v[x][y][0] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == n - 1 && cur.y == m - 1) {
                min = Math.min(min, cur.time);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                //범위를 벗어나면
                if(0>nx||0>ny||nx>=n||ny>=m) continue;
                //이미 방문했으면
                if(v[nx][ny][cur.flag]) continue;
                //검을 만나면
                if (map[nx][ny] == 2) {
                    v[nx][ny][cur.flag] = true;
                    q.add(new Point(nx, ny, cur.time + 1, 1));
                }
                //벽을 만나면
                if (map[nx][ny] == 1) {
                    if (cur.flag==1) {
                        v[nx][ny][cur.flag] = true;
                        q.add(new Point(nx, ny, cur.time + 1, cur.flag));
                    }
                }
                //빈칸 go
                if (map[nx][ny] == 0) {
                    v[nx][ny][cur.flag] = true;
                    q.add(new Point(nx, ny, cur.time + 1, cur.flag));
                }
            }
        }
    }
}
