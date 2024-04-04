package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//바이러스
public class BOJ2606 {

    static int n, m;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        for (int i = 1; i <=n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        System.out.println(bfs(1));


    }

    private static int bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];
        q.add(x);
        v[x] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (int next : graph[now]) {
                if (!v[next]) {
                    v[next] = true;
                    cnt++;
                    q.add(next);
                }
            }
        }
        return cnt;
    }
}
