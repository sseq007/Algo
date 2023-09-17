package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리 {

    static class Point{
        int x,y,dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }
    static int n,m;
    static int[][] map;
    static int[][] result;
    static boolean[][] v;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2||map[i][j]==0) {
                    result[i][j]=0;

                }else {
                    bfs(i, j);
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        v = new boolean[n][m];
        q.add(new Point(x, y,0));
        v[x][y]=true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (map[p.x][p.y] == 2) {
                result[x][y] = p.dist;
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if (0 <= nx && 0 <= ny && nx < n && ny < m && !v[nx][ny] && map[nx][ny] != 0) {
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny, p.dist + 1));
                }

            }


        }
        result[x][y]=-1;


    }
}
