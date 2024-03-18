package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 킹 {

    static int[] dx = {0,0,1,-1,1,1,-1,-1};
    static int[] dy = {1,-1,0,0,1,-1,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            char[] k = king.clone();
            char[] s = stone.clone();
            move(input, k);
            if (!isCheck(k)) {
                continue;
            }
            if (Arrays.equals(k, s)) {
                move(input, s);
                if (!isCheck(s)) {
                    continue;
                }
            }
            king = k;
            stone = s;
        }
        System.out.println(king);
        System.out.println(stone);
    }

    private static boolean isCheck(char[] next) {
        if (next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8') {
            return false;
        }
        return true;
    }

    private static void move(String input, char[] next) {

        switch (input) {
            case "R": next[0]++; break;
            case "L": next[0]--; break;
            case "B": next[1]--; break;
            case "T": next[1]++; break;
            case "RT": next[0]++;next[1]++; break;
            case "LT": next[0]--;next[1]++; break;
            case "RB": next[0]++;next[1]--; break;
            case "LB": next[0]--;next[1]--; break;
        }
    }
}
