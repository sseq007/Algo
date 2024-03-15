package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 크리스마스선물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append(-1+"\n");
                } else {
                    sb.append(pq.poll() + "\n");
                }

            } else {

                while (st.hasMoreTokens()) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }

            }
        }
        System.out.println(sb);
    }
}
