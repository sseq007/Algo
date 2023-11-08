package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 어두운건무서워 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] map = new int[r + 1][c + 1];

        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=c; j++) {
                if (j == 1 && i != 1) {
                    map[i][j] = Integer.parseInt(st.nextToken()) + map[i - 1][c];
                    continue;
                }
                map[i][j] = Integer.parseInt(st.nextToken())+map[i][j-1];
            }
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int size = (y2 - y1 + 1) * (x2 - x1 + 1);



        }
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
}
