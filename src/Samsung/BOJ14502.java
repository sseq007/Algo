package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {

    static class Point{
        int x,y,cnt;

        public Point(int x,int y){
            this.x =x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x:"+x+"y:"+y;
        }

    }
    static int n,m,max = 0;
    static int[][] map;
    static Point[] sel;
    static List<Point> list;
    static Queue<Point> q;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        list = new ArrayList<>();
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    list.add(new Point(i, j));
                }


            }
        }
        sel = new Point[3];
        comb(0, 0);
        System.out.println(max);
    }

    private static void comb(int idx, int s) {

        if (idx == sel.length) {
//            System.out.println(Arrays.toString(sel));
            v = new boolean[n][m];
            int[][] copyArray = copy();
            for (int i = 0; i < sel.length; i++) {
                copyArray[sel[i].x][sel[i].y] = 1;
            }
            max = Math.max(max, bfs(copyArray));
            return;
        }

        for (int i = s; i <list.size() ; i++) {
            sel[idx] = list.get(i);
            comb(idx + 1, i + 1);
        }
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    private static int bfs(int[][] copyArray) {

        while (!q.isEmpty()) {
            Point cur = q.poll();
//            System.out.println(cur);
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
//                if(v[nx][ny]) continue;
                if (copyArray[nx][ny] == 0) {
//                    v[nx][ny] = true;
                    q.add(new Point(nx, ny));
                    copyArray[nx][ny]=2;
                }
            }
        }
        int cnt =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyArray[i][j] == 0) {
                    cnt++;
                }
            }
        }
//        print(copyArray);
//        System.out.println(cnt);

        return cnt;
    }

    private static int[][] copy() {
        int[][] copy = new int[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = map[i][j];
                if (map[i][j] == 2) {
                    q.add(new Point(i, j));
//                    v[i][j] = true;
                }
            }
        }
        return copy;

    }

    private static void print(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
