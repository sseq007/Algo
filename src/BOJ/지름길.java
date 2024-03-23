package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class 지름길 {

    static class Point implements Comparable<Point>{
        int x,y,dist;
        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.dist,o.dist);
        }
    }

    static List<Point>[] graph;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
