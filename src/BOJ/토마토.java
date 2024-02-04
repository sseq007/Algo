package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static class Point{
        int x,y,h,cnt;

        public Point(int x, int y, int h, int cnt) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", h=" + h +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    static int n,m,h;
    static int[][][] map;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        boolean isALl = true;
        Queue<Point> q = new LinkedList<>();
        boolean[][][] v = new boolean[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[i][j][k] = input;
                    if (input == 0) {
                        isALl = false;
                    } else if (input == 1) {
                        q.add(new Point(j, k, i, 0));
                        v[i][j][k] = true;
                    } else {
                        v[i][j][k] = true;
                    }

                }
            }
        }
        int result = -1;
        if (isALl) {
            System.out.println(0);

        } else {
            while (!q.isEmpty()) {
                Point p = q.poll();

                result = Math.max(result,p.cnt);


                for (int d = 0; d < 6; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];
                    int nh = p.h + dh[d];
                    if(0>nx||0>ny||0>nh||nx>=n||ny>=m||nh>=h) continue;
                    if(v[nh][nx][ny]) continue;

                    if (map[nh][nx][ny] == 0) {
                        v[nh][nx][ny] = true;
                        q.add(new Point(nx, ny, nh, p.cnt + 1));
                    }
                }
            }
            System.out.println(!check(v)?-1:result);
        }
    }

    private static boolean check(boolean[][][] v) {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!v[i][j][k]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
