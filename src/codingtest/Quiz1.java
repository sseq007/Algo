package codingtest;
import java.io.*;
import java.util.*;

public class Quiz1 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //두 좌표 사이의 거리 합 구하는 메소드
    private static double sumDist(Point point, List<Point> points) {
        double sum = 0;
        for (Point other : points) {
            sum += dist(point, other);
        }
        return sum;
    }
    // 두 좌표 사이의 거리 구하는 메소드
    private static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(", ");
        List<Point> points = new ArrayList<>();
        //입력 받기
        for (int i = 0; i < input.length; i++) {
            String[] coordinates = input[i].substring(1, input[i].length() - 1).split(",");
            points.add(new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])));
        }
        //좌표 사이의 거리 합이 가까운 순으로 정렬
        points.sort((p1, p2) -> Double.compare(sumDist(p1, points), sumDist(p2, points)));

        for (Point p : points) {
            System.out.println("(" + p.x + "," + p.y + ")");
        }
    }






}
