package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

//카드 정렬하기
public class BOJ1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
            pq.add(card[i]);
        }
        Arrays.sort(card);
        int result =0;
        int cnt = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            sum+=pq.poll();
            cnt++;
            if (cnt == 2) {
                result += sum;
                pq.add(sum);
                sum =0;
                cnt=0;
            }

        }
        System.out.println(result);

    }
}
