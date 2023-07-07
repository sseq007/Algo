package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 데스나이트 {
    static class Point {
        int x,y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int n,minMove=Integer.MAX_VALUE;
    static int x1,x2,y1,y2;
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        bfs(x1, y1);
        System.out.println(minMove==Integer.MAX_VALUE?-1:minMove);
    }

    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};
    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] v = new boolean[n][n];
        q.add(new Point(x, y, 0));
        v[x][y]=true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == x2 && p.y == y2) {
                minMove = p.cnt;
                return;
            }
            for (int d = 0; d <6 ; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (0 <= nx && 0 <= ny && nx < n && ny < n && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny, p.cnt + 1));
                }

            }
        }
    }
}
