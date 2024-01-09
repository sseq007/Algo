package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//boj 1205
public class 등수구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        Integer[] scores = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores, Collections.reverseOrder());

        if (p == n && scores[n - 1] >= score) {
            System.out.print(-1);
        }
        else {
            int rank = 1;
            for (int i = 0; i < n; i++) {

                if (scores[i] > score) {
                    rank++;
                } else break;
            }
            System.out.print(rank);
        }
    }
}
