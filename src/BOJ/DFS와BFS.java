package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class DFS와BFS {
    static LinkedList<Integer>[] graph;
    static int n,m,v;
    static boolean[] V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        graph = new LinkedList[n+1];

        for (int i = 1; i < n+1; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            Collections.sort(graph[i]);
        }

        V = new boolean[n + 1];

        dfs(v);
        System.out.println();
        V = new boolean[n + 1];

        bfs(v);



    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        V[x] = true;
        q.offer(x);

        while (!q.isEmpty()) {
            int p = q.poll();
            System.out.print(p+" ");
            for (int next : graph[x]) {
                if (!V[next]) {
                    V[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private static void dfs(int x) {

        V[x] = true;
        System.out.print(x+" ");
        for ( int next : graph[x]) {
            if (!V[next]) {
                dfs(next);
            }

        }

    }
}
