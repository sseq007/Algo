package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 알고스팟 {

    static class Point implements Comparable<Point>{
        int x,y,cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point point) {
            return Integer.compare(cnt, point.cnt);
        }
    }
    static int n,m,min_wall=Integer.MAX_VALUE;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
        bfs(0, 0);
        System.out.println(min_wall);

    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void bfs(int x, int y) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[][] v = new boolean[n][m];
        pq.add(new Point(x, y, 0));
        v[x][y] = true;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.x == n - 1 && p.y == m - 1) {
                min_wall = p.cnt;
                return;

            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                //범위가 벗어나면
                if(nx<0||nx>=n||ny<0||ny>=m) continue;
                //벽을 만나면
                if (!v[nx][ny] && map[nx][ny] == 1) {
                    v[nx][ny] = true;
                    pq.add(new Point(nx, ny, p.cnt + 1));
                }
                //벽이 아니면
                if (!v[nx][ny] && map[nx][ny] == 0) {
                    v[nx][ny] = true;
                    pq.add(new Point(nx, ny, p.cnt ));
                }

            }
        }


    }
}
