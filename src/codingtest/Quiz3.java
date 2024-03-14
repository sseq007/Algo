package codingtest;
import java.util.*;

public class Quiz3 {
    static class Position {
        private Integer x;
        private Integer y;

        public Position(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%s,%s)", x, y);
        }
    }
    //두 좌표에서
    public static void printAllPositions(List<Integer> list1, List<Integer> list2) {
        for (Integer i : list1) {
            for (Integer j : list2) {
                System.out.println(new Position(i, j));
                System.out.println(new Position(j, i));
            }
        }
    }

    public static void main(String[] args) {
        //주어진 입력값
        final var integers1 = List.of(1, 2, 3);
        final var integers2 = List.of(4, 5);


        printAllPositions(integers1, integers2);

    }


}
