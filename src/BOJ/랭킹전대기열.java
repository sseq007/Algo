package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 랭킹전대기열 {
    static class Point{
        String name;
        int level;
        boolean flag;
        public Point(String name, int level, boolean flag) {
            this.name = name;
            this.level = level;
            this.flag = flag;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Point[] player = new Point[p];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
                    player[i] = new Point(b,a , false);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p; i++) {
            List<Point> list = new ArrayList<>();
            if (!player[i].flag) {
                for (int j = i; j < p; j++) {
                    if (list.size() == m) {
                        break;
                    }
                    String name = player[j].name;
                    int level = player[j].level;
                    if (!player[j].flag && player[i].level - 10 <= level && player[i].level + 10 >= level) {
                        player[j].flag = true;
                        list.add(new Point(name, level, false));
                    }
                }
                Collections.sort(list,(o1,o2)->
                        o1.name.compareTo(o2.name));
                if (list.size() == m) {
                    sb.append("Started!").append("\n");
                } else {
                    sb.append("Waiting!").append("\n");
                }
                for (Point pl : list) {
                    sb.append(pl.level).append(" ").append(pl.name).append("\n");
                }
            }


        }
        System.out.println(sb);
    }

}
