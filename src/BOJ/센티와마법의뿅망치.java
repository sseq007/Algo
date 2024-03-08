package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 센티와마법의뿅망치 {
    static class Point implements Comparable<Point>{
        int height;

        public Point(int height) {
            this.height = height;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(o.height,this.height);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "height=" + height +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Point(Integer.parseInt(br.readLine())));
        }
        int cnt = 0;
        while (t-- > 0) {
            if ((pq.peek().height < h) || (pq.peek().height == 1)) {
                break;
            }
            cnt++;
            Point cur = pq.poll();
            cur.height /= 2;
            pq.add(cur);
        }
        if (pq.peek().height<h) {
            System.out.println("YES");
            System.out.println(cnt);
        } else {
            System.out.println("NO");
            System.out.println(pq.peek().height);
        }





    }
}
