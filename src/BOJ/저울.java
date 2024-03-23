package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class 저울 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b]=1;
            map[b][a]=2;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j]=1;
                    } else if (map[i][k] == 2 && map[k][j] == 2) {
                        map[i][j]=2;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int cnt =0;
            for (int j = 1; j <= n; j++) {
                if (i != j && map[i][j] == 0) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
