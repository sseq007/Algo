package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//모양 만들기
public class BOJ16932 {

    static class Point{
        int x,y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int n,m,max =0,cnt;
    static int[][] map;
    static int[][] v;
    static List<Integer> list ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new int[n][m];
        list = new ArrayList<>();
        int idx = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] == 0 && map[i][j] == 1) {
                    cnt=1;
                    bfs(i, j,idx);
                    idx++;
                    list.add(cnt);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    max = Math.max(max, counting(i, j));
                }
            }
        }
        System.out.println(max);



    }

    private static int counting(int x, int y) {

        int sum =1;
        Set<Integer> set = new HashSet<>();

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(0>nx||0>ny||nx>=n||ny>=m) continue;
            if(map[nx][ny]==0) continue;
            set.add(v[nx][ny]);
        }
        for (int val : set) {
            sum += list.get(val - 1);
        }

        return sum;
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private static void bfs(int x, int y,int idx) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1));
        v[x][y] = idx;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(0>nx||0>ny||nx>=n||ny>=m) continue;
                if(v[nx][ny]!=0) continue;
                if(map[nx][ny]==0) continue;
                v[nx][ny] = idx;
                q.add(new Point(nx, ny, cur.cnt + 1));
                cnt++;

            }
        }
//        return cnt;
    }
}
