package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//치킨 배달
public class BOJ15686 {

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
    static List<Point> home;
    static List<Point> chicken;
    static int n,m,min=Integer.MAX_VALUE;
    static int[][] map;
    static Point[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Point(i+1, j+1));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i+1, j+1));
                }
            }
        }
        sel = new Point[m];
//        for (int i = 1; i <= m; i++) {
            comb(0,0);
//        }
        System.out.println(min);

    }

    private static void comb(int idx, int s) {

        if (idx == sel.length) {
            int sum = 0;
//            System.out.println(Arrays.toString(sel));
            for (Point homePoint : home) {
                int min_dist = Integer.MAX_VALUE;
                for (int i = 0; i < sel.length; i++) {
                    int dist = Math.abs(homePoint.x - sel[i].x) + Math.abs(homePoint.y- sel[i].y) ;
                    min_dist = Math.min(min_dist, dist);
                }
                sum += min_dist;
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = s; i < chicken.size(); i++) {
            sel[idx] = chicken.get(i);
            comb(idx+1,i+1);
        }
    }


}
