package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//최소 스패닝 트리(크루스칼)
public class BOJ1197Kru {

    static class Point implements Comparable<Point>{
        int to, from , weight;

        public Point(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return weight-o.weight;
        }
    }

    static int[] parents;
    static int v,e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
        Queue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Point(a, b, c));
        }

        int sum =0;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (find(cur.to) != find(cur.from)) {
                union(cur.to, cur.from);
                sum += cur.weight;
            }
        }
        System.out.println(sum);

    }

    private static void union(int to, int from) {
        int p1 = find(to);
        int p2 = find(from);
        if (p1 < p2) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
        }
    }

    private static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}
