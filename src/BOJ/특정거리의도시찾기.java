package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {
    static class Point{
        int x,dist;
        public Point(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> city;
    static int n,m,k,x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 1; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }
        city = new ArrayList<>();
        bfs(x);
        if (city.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(city);
            for (int num : city) {
                System.out.println(num);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Point> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];
        q.add(new Point(x,0));
        v[x] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.dist == k) {
                city.add(p.x);
            }
            for (int next : graph[p.x]) {
                if (!v[next]) {
                    v[next] = true;
                    q.add(new Point(next,p.dist+1));
                }
            }
        }
    }
}
