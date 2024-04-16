package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {

    static int n,max = 0;
    static int[][] egg;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        egg = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                egg[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0);
        System.out.println(max);
    }

    private static void recur(int idx, int cnt) {
        if (idx == n || cnt == n-1) {
            max = Math.max(max, cnt);
            return;
        }
        //진행
        //만약 egg가 깨져있다면
        if (egg[idx][0] <= 0) {
            //다음으로 진행
            recur(idx + 1, cnt);
        } else {
            for (int i = 0; i < n; i++) {
                if(i==idx) continue;
                if (egg[i][0] > 0) {
                    egg[idx][0] -= egg[i][1];
                    egg[i][0] -= egg[idx][1];
                    recur(idx + 1, cnt + (egg[idx][0] > 0 ? 0 : 1) + (egg[i][0] > 0 ? 0 : 1));
                    egg[idx][0] += egg[i][1];
                    egg[i][0] += egg[idx][1];
                }
            }
        }
    }

}
