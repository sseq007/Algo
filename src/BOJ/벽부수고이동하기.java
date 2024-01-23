package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

    static class Point{
        int x, y,cnt;
        boolean flag;

        public Point(int x, int y, int cnt,boolean flag) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.flag = flag;
        }
    }
    static int[][] map;
    static int n,m,min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        boolean[][][] v = new boolean[n][m][2];
        q.add(new Point(x, y, 1,false));
        v[x][y][0] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == n - 1 && p.y == m - 1) {
                min = p.cnt ;
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if(0>nx||0>ny||nx>=n||ny>=m) continue;
                //벽을 만나면
                if (map[nx][ny] == 1) {
                    //한번도 부신적이 없으면
                    if (!p.flag) {
                        q.add(new Point(nx, ny, p.cnt + 1,true));
                        v[nx][ny][1] = true;
                    }
                }
                //벽은 안만나면
                if (map[nx][ny] == 0) {
                    //벽을 부시고 온 놈
                    if (p.flag&&!v[nx][ny][1]) {
                        q.add(new Point(nx, ny, p.cnt + 1,true));
                        v[nx][ny][1] = true;
                    }else if(!p.flag&&!v[nx][ny][0]){
                        //아닌넘
                        q.add(new Point(nx, ny, p.cnt + 1,false));
                        v[nx][ny][0] = true;

                    }
                }
            }
        }

    }
}
