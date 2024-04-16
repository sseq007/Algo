package MST;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//도시 건설
public class BOJ21924 {

    static class Point implements Comparable<Point>{
        int v1,v2,weight;
        public Point(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        @Override
        public int compareTo(Point p) {
            return weight - p.weight;
        }

    }

    static int n,m;
    static int[] parent;
    static Queue<Point> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <=n; i++) {
            parent[i] = i;
        }
        pq = new PriorityQueue<>();
        long total=0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total += c;
            pq.add(new Point(a, b, c));
        }

        long sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (find(cur.v1) != find(cur.v2)) {
                union(cur.v1, cur.v2);
                sum += cur.weight;
                cnt++;
            }

        }
        System.out.println(cnt==n-1?total-sum:"-1");

    }

    private static void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1<p2) parent[p2] = p1;
        else parent[p1] = p2;
    }

    private static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

}
