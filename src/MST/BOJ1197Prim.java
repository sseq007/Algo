package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//최소 스패닝 트리(프림)
public class BOJ1197Prim {
    static class Point implements Comparable<Point>{
        int to,weight;

        public Point(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Point p) {
            return weight - p.weight;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
    static List<Point>[] graph;
    static int v,e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        graph = new List[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Point(b, c));
            graph[b].add(new Point(a, c));
        }
        PriorityQueue<Point> q = new PriorityQueue<>();

        boolean[] visited = new boolean[v + 1];
        q.add(new Point(1, 0));
        int sum = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if(visited[cur.to]) continue;
            visited[cur.to] = true;
            sum += cur.weight;
            for (Point next : graph[cur.to]) {
                if (!visited[next.to]) {
                    q.add(next);

                }
            }

        }
        System.out.println(sum);
    }
}
