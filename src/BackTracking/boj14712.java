package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//넴모넴모(Easy)
public class boj14712 {

    static int n,m,cnt;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = new boolean[n][m];
        cnt = 0;
        dfs(0, 0);
        System.out.println(cnt);
    }

    private static void dfs(int idx, int start) {

        cnt += (check(idx) ? 1 : 0);

        if (idx == n * m) {
            return;
        }
        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;
            v[x][y] = true;
            dfs(idx+1,i+1);
            v[x][y] = false;
        }
    }

    private static boolean check(int idx) {
        if(idx<4) return true;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                if(v[i][j]&&v[i][j+1]&&v[i+1][j]&&v[i+1][j+1]) return false;
            }
        }
        return true;


    }
}
