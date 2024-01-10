package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿠키의신체측정 {

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        int heartX = 0, heartY = 0;
        //심장 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if (0 <= nx && nx < n && 0 <= ny && ny < n && map[nx][ny] == '*') {
                            cnt++;
                        }
                    }
                    if (cnt == 4) {
                        heartX = i;
                        heartY = j;
                    }
                }
            }
        }
        int left_arm=0,right_arm=0,back=0,left_leg=0,right_leg=0;
        //왼쪽 팔, 오른쪽 팔,허리,왼쪽 다리, 오른쪽 다리
        int a = heartX;
        int b = heartY;
        int c = heartX;
        int d = heartY;
        int e = heartX;
        int f = heartY;


        while (b-1>=0&&map[a][b-1] == '*') {
            left_arm++;
            b--;
        }
        while (d+1<n&&map[c][d+1] == '*') {
            right_arm++;
            d++;
        }
        while (map[e+1][f] == '*') {
            back++;
            e++;
        }
        int g = e+1;
        int h = f-1;
        int i = e+1;
        int j = f+1;
        while (g<n&&map[g][h] == '*') {
            left_leg++;
            g++;
        }
        while (i<n&&map[i][j] == '*') {
            right_leg++;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(heartX+1 + " ").append(heartY+1 + " ").append("\n");
        sb.append(left_arm + " ").append(right_arm + " ").append(back + " ").append(left_leg + " ").append(right_leg+" ");
        System.out.println(sb);




    }
}
