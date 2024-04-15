package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16234 {

    static class Point{
        int x,y,val;
        public Point(int x, int y,int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,l,r,max_cnt;
    static int[][] map;
    static boolean[][] v;
    static List<Point> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            v = new boolean[n][n];

            boolean flag = false;
            //국경 연결
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            move(sum);
                            flag = true;
                        }
                    }
                }
            }
            //만약 국경선이 다 닫혀있는 경우
            if(!flag) break;
            //인구 이동
            day++;
        }
        System.out.println(day);
    }

    private static void move(int sum) {
        int size = sum / list.size();
        for (Point p : list) {
            map[p.x][p.y] = size;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        list = new ArrayList<>();
        q.add(new Point(x, y,map[x][y]));
        v[x][y] = true;
        list.add(new Point(x, y));
        int sum = map[x][y];
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                //범위가 벗어나면
                if(0>nx||0>ny||nx>=n||ny>=n) continue;
                //방문 했다면
                if(v[nx][ny]) continue;
                //만약 인구차이가 l명이상 r명이하라면
                if (Math.abs(cur.val - map[nx][ny]) >= l && Math.abs(cur.val - map[nx][ny]) <= r) {
                    sum += map[nx][ny];
                    list.add(new Point(nx, ny));
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny, map[nx][ny]));
                }
            }
        }
        return sum;

    }
}
