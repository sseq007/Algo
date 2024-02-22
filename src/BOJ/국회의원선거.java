package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 국회의원선거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2 - o1);
        int first =0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                first = Integer.parseInt(br.readLine());
                continue;
            }
            pq.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(pq);
        int cnt =0;
        while (!pq.isEmpty()&&first <= pq.peek()) {
            first += 1;
            pq.add(pq.poll() - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
