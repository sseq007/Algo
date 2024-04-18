package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for (int i = 1; i < 20; i++) {
                for (int j = i; j >= 0; j--) {
                    if (arr[j] > arr[i]) {
                        cnt++;
                    }
                }
            }
            System.out.println(t+" "+cnt);
//            Deque<Integer> dq = new LinkedList<>();
//            int cnt = 0;
//            while (st.hasMoreTokens()) {
//                if (dq.isEmpty()) {
//                    dq.add(Integer.parseInt(st.nextToken()));
//                    continue;
//                }
//                int next = Integer.parseInt(st.nextToken());
//                if (dq.peekLast() > next) {
//                    cnt += dq.size();
//                    dq.addFirst(next);
//
//                } else {
//                    dq.addLast(next);
//                }
//            }
//            System.out.println(t+" "+cnt);
        }
    }
}
