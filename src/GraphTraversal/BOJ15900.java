package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//나무 탈출
public class BOJ15900 {

    static int n,sum;
    static List<Integer>[] graph;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        v = new boolean[n+1];
        v[1] = true;
        sum=0;
        dfs(1,0);
        System.out.println(sum%2==0?"No":"Yes");
    }

    private static void dfs(int x,int depth) {

        if(x!=1&&graph[x].size()==1&&v[graph[x].get(0)]){
            sum += depth;
            return;
        }

        for(int next : graph[x]){
            if (!v[next]) {
                v[next] = true;
                dfs(next, depth + 1);
            }

        }


    }
}
