package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 도시건설 {
    static class Point implements Comparable<Point>{
        int x,val;
        public Point(int x, int val) {
            this.x = x;
            this.val= val;
        }
        @Override
        public int compareTo(Point point) {
            return Integer.compare(val, point.val);
        }
    }
    static int n,m;
    static ArrayList<Point>[] graph;
    static boolean[] v;
    static long allCost,cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        allCost=0;
        cost=0;
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            graph[a].add(new Point(b, val));
            graph[b].add(new Point(a, val));
            allCost += val;
        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(1, 0));
        v = new boolean[n + 1];
//        v[1] = true;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if(v[p.x]) continue;
            v[p.x] = true;
            cost += p.val;
            for (Point next : graph[p.x]) {
                if (!v[next.x]) {
//                    v[next.x] = true;
                    pq.add(next);
                }
            }
        }
        boolean flag = false;
        //모든 도시가 연결되어있는지 판별
        for (int i = 1; i <=n ; i++) {
            if (!v[i]) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(-1);
        } else {

            System.out.println(allCost-cost);
        }

    }
}
