package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//트리
public class BOJ1068 {

    static List<Integer>[] graph;
    static int n, m,cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == -1) {
                start = i;
                continue;
            }
            graph[num].add(i);
            graph[i].add(num);
        }
        m = Integer.parseInt(br.readLine());

        cnt =0;
        bfs(start);
        System.out.println(cnt);




    }

    private static void bfs(int start) {
        if(start==m) return;
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n];
        q.add(start);
        v[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            boolean flag =false;
            for (int next : graph[cur]) {
                if(v[next]) continue;
                if(next==m) continue;
                flag = true;
                v[next] = true;
                q.add(next);
            }
            if (!flag) {
                cnt++;
            }
        }
    }

}
