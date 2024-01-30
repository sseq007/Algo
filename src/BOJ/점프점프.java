package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프점프 {

    static class Point{
        int idx, x,cnt;

        public Point(int idx, int x, int cnt) {
            this.idx = idx;
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Point> q = new LinkedList<>();
        boolean[] v = new boolean[n];
        q.add(new Point(0,arr[0],0));
        v[0] = true;
        int result = -1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.idx == n - 1) {
                result = p.cnt;
                break;

            }
            for (int i = p.idx; i <= p.idx + p.x; i++) {
                if (i < n && !v[i]) {
                    q.add(new Point(i, arr[i],p.cnt+1));
                    v[i] = true;
                }
            }
        }
        System.out.println(result);



    }

}
