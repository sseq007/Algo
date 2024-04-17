package BruteForce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//동전 게임
public class BOJ9079 {

    static class Point{
        int val,cnt;
        public Point(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            map = new int[3][3];
            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    if (st.nextToken().equals("H")) {
                        map[i][j] = 0;
                    } else {
                        map[i][j] = 1;
                    }
                }
            }
            System.out.println(  bfs());


        }
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        boolean[] v = new boolean[512];
        int bi = makeBinary();
        v[bi] = true;
        q.add(new Point(bi, 0));
        while (!q.isEmpty()) {
            Point now = q.poll();
            makeMap(now.val);

            if (check()) {
                return now.cnt;
            }

            for (int i = 0; i < 3; i++) {
                col_change(i);
                int next = makeBinary();
                if (!v[next]) {
                    v[next] = true;
                    q.add(new Point(next, now.cnt + 1));
                }
                col_change(i);
            }

            for (int i = 0; i < 3; i++) {
                row_change(i);
                int next = makeBinary();
                if (!v[next]) {
                    v[next] = true;
                    q.add(new Point(next, now.cnt + 1));
                }
                row_change(i);
            }

            for (int i = 0; i < 2; i++) {
                cross_change(i);
                int next = makeBinary();
                if (!v[next]) {
                    v[next] = true;
                    q.add(new Point(next, now.cnt + 1));
                }
                cross_change(i);
            }

        }


        return -1;
        }

    private static void cross_change(int i) {
        for (int j = 0; j < 3; j++) {
            if (i == 0) {
                map[j][j] = map[j][j] == 0 ? 1 : 0;
            } else {
                map[j][2 - j] = map[j][2 - j] == 0 ? 1 : 0;
            }

        }
    }

    private static void row_change(int i) {
        for (int j = 0; j < 3; j++) {
            map[j][i] = map[j][i] == 0 ? 1 : 0;
        }
    }

    private static void col_change(int i) {
        for (int j = 0; j < 3; j++) {
            map[i][j] = map[i][j] == 0 ? 1 : 0;
        }

    }


    private static boolean check() {
        int temp = map[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(map[i][j]!=temp) return false;
            }
        }
        return true;


    }

    private static void makeMap(int val) {
        for (int i = 2; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                map[i][j]=val%2;
                val /= 2;
            }
        }
    }

    private static int makeBinary() {
        int now = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                now = now * 2 + map[i][j];

            }
        }
        return now;
    }
}
