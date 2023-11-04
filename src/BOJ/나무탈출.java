package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 나무탈출 {
    static int n,sum;
    static LinkedList<Integer>[] graph;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new LinkedList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        v = new boolean[n + 1];
        sum = 0;
        dfs(1, 0);

        System.out.println(sum%2==0?"No":"Yes");


    }

    private static void dfs(int x, int cnt) {
        v[x] = true;

        for (int next : graph[x]) {
            if (!v[next]) {
                dfs(next, cnt + 1);
            }
        }

        //리프 노드인 경우
        if (graph[x].size() == 1 && x != 1) {

            sum += cnt;

        }

    }


}