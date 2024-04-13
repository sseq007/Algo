package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6987 {

    static class Point{
        int win,draw,lose;
        public Point(int win, int draw, int lose) {
            this.win = win;
            this.draw = draw;
            this.lose = lose;
        }
    }
    static int[][] match;
    static Point[] country;
    static Point[] sel;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        country = new Point[6];
        match = new int[15][2];
        int num = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i+1; j <6 ; j++) {
                match[num][0] = i;
                match[num][1] = j;
                num++;
            }
        }
        sel = new Point[6];

        StringBuilder sb = new StringBuilder();
        loop:
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                sel[j] = new Point(0, 0, 0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
//                if (a + b + c != 5) {
//                    sb.append(0).append(" ");
//                    continue loop;
//                }
                country[j] = new Point(a, b, c);
            }
            flag = false;
            play(0);
            sb.append(flag ? 1 : 0).append(" ");


        }
        System.out.println(sb);


    }

    private static void play(int idx) {
        if (idx == 15) {
            for (int i = 0; i < 6; i++) {
                if (country[i].win!=sel[i].win ||country[i].draw!= sel[i].draw ||country[i].lose!=sel[i].lose ) {
                    return;
                }
            }
            flag = true;
            return;

        }
        int team1 = match[idx][0];
        int team2 = match[idx][1];

        sel[team1].win++;
        sel[team2].lose++;
        play(idx + 1);
        sel[team1].win--;
        sel[team2].lose--;

        sel[team1].draw++;
        sel[team2].draw++;
        play(idx + 1);
        sel[team1].draw--;
        sel[team2].draw--;

        sel[team1].lose++;
        sel[team2].win++;
        play(idx + 1);
        sel[team1].lose--;
        sel[team2].win--;


    }
}
