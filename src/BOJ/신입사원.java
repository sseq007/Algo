package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 신입사원 {
    static class Score implements Comparable<Score> {
        int a,b;
        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Score s) {
            return Integer.compare(this.a,s.a);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            List<Score> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Score(a, b));
            }
            Collections.sort(list);
            int min = list.get(0).b;
            int anw = 1;
            for (int i = 1; i < n; i++) {
                if (list.get(i).b < min) {
                    anw++;
                    min = list.get(i).b;
                }
            }
            System.out.println(anw);

        }
    }
}
