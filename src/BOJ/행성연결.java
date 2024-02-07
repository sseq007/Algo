package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 행성연결 {

    static class Point implements Comparable<Point>{
        int x,val;

        public Point(int x, int val) {
            this.x = x;
            this.val = val;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(val,o.val);
        }
    }

    static ArrayList<Point>[] graph;
    static boolean[] v;
    static int n;
    static long total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int weight = Integer.parseInt(st.nextToken());
                graph[i].add(new Point(j, weight));
            }
        }
        v = new boolean[n];

        prim(0);
        System.out.println(total);

    }

    private static void prim(int start) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        pq.add(new Point(start, 0));

        int cnt = 0;
        while (!pq.isEmpty()) {
            if(cnt==n) break;

            Point p = pq.poll();

            if(v[p.x]) continue;
            v[p.x] = true;
            total += p.val;
            cnt++;
            for (Point next : graph[p.x]) {
                if (!v[next.x]) {
                    pq.add(next);
                }
            }


        }
    }
}
