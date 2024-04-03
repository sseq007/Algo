package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725 {

    static int n;
    static List<Integer>[] graph;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        for (int i = 1; i <=n ; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        v = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;
        while (!q.isEmpty()) {
            Integer now = q.poll();
            for (int next : graph[now]) {
                if (!v[next]) {
                    v[next] = true;
                    q.add(next);
                    parent[next] = now;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }

    }


}
