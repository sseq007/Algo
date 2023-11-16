package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    static class Point{
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static Point[] sel;
    static int n,m,min;
    static int[][] map;
    static List<Point> home;
    static List<Point> chicken;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Point(i, j));
                }
                else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        min = Integer.MAX_VALUE;
        for (int i = 1; i <=m; i++) {
            sel = new Point[i];
            recur(0, 0);
        }
        System.out.println(min);
    }
    private static void recur(int idx, int s) {
        if (idx == sel.length) {
//            System.out.println(Arrays.toString(sel));
            int dist = 0;

            for (int i = 0; i < home.size(); i++) {
                int min_dist = Integer.MAX_VALUE;
                int sum=0;
                for (int j = 0; j < sel.length; j++) {
                    sum = Math.abs(home.get(i).x - sel[j].x) + Math.abs(home.get(i).y - sel[j].y);
                    min_dist = Math.min(min_dist, sum);
//                    if(min_dist>sum) min_dist = sum;
                }
                dist += min_dist;
            }
//            if(min>dist) min = dist;
            min = Math.min(min, dist);
            return;

        }

        for (int i = s; i <chicken.size(); i++) {
            sel[idx] = chicken.get(i);
            recur(idx+1,i+1);
        }

    }
}
