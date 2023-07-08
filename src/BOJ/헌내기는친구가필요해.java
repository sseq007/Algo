package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m,cnt;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        int startX=0,startY=0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j]=='I'){
                    startX = i;
                    startY = j;
                }
            }
        }
        cnt=0;
        bfs(startX, startY);
        System.out.println(cnt==0?"TT":cnt);
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        boolean[][] v = new boolean[n][m];
        v[x][y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if(map[p.x][p.y]=='P'){
                cnt++;
            }
            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (0 <= nx && 0 <= ny && nx < n && ny < m && map[nx][ny] != 'X' && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }

        }
    }
}
