package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1922 {

    static class Point implements Comparable<Point>{
        int v1,v2,weight;
        public Point(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        @Override
        public int compareTo(Point o) {
            return weight-o.weight;
        }
    }
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        Queue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Point(a, b, c));
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                sum += cur.weight;
            }
        }
        System.out.println(sum);
    }

    private static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    private static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
}
