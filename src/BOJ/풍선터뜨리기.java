package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 풍선터뜨리기 {

    static class Point{
        int idx,val;
        public Point(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ballnoon = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ballnoon[i] = Integer.parseInt(st.nextToken());
        }
        Deque<Point> q = new ArrayDeque<>();

        for (int i = 1; i <n ; i++) {
            q.add(new Point(i+1,ballnoon[i]));
        }
        int move = ballnoon[0];
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        while (!q.isEmpty()) {

            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    q.add(q.poll());
                }
                Point p = q.poll();
                move = p.val;
                sb.append(p.idx + " ");
            } else {
                for (int i = 1; i < -move; i++) {
                    q.addFirst(q.pollLast());
                }
                Point p = q.pollLast();
                move = p.val;
                sb.append(p.idx + " ");
            }



        }
        System.out.println(sb);
    }
}
