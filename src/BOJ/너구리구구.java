package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 너구리구구 {

    static class Point{
        int x, val;

        public Point(int x, int val) {
            this.x = x;
            this.val = val;
        }
    }
    static int n;
    static long max;
    static List<Point>[] graph;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Point(b,c));
            graph[b].add(new Point(a, c));
        }
        v = new boolean[n + 1];
        v[1] = true;
        dfs(1, 0);
        System.out.println(max);


    }

    private static void dfs(int x, long sum) {
        max = Math.max(max, sum);

        for (Point p : graph[x]) {
            if(v[p.x]) continue;
            v[p.x] = true;
            dfs(p.x, sum + p.val);
        }

    }
}
