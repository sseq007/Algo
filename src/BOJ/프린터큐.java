package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐 {

    static class Point{
        int x,val;
        public Point(int x,int val) {
            this.x = x;
            this.val = val;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Point> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            List<Integer> set = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int input = Integer.parseInt(st.nextToken());
                q.add(new Point(i, input));
                set.add(input);
            }
            Collections.sort(set, Collections.reverseOrder());

            int cnt=0;
            int idx = 0;
            while (!q.isEmpty()) {
                Point cur = q.poll();

                if (cur.val < set.get(idx)) {
                    q.add(cur);
                }else {
                    idx++;
                    cnt++;
                    if (cur.x== m) {
                        break;
                    }
                }




            }
            System.out.println(cnt);
        }

    }
}
