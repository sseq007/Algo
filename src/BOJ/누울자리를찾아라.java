package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 누울자리를찾아라 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map  = new char[n][n];

        int cnt1=0;
        int cnt2=0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    if (str.length() >= 2) {
                        cnt1++;
                    }
                    str ="";
                    continue;
                }
                str+=map[i][j];
            }
            if (str.length() >= 2) {
                cnt1++;
            }
        }

        for (int i = 0; i < n; i++) {
            String str = "";
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 'X') {
                    if (str.length() >= 2) {
                        cnt2++;
                    }
                    str ="";
                    continue;
                }
                str+=map[j][i];
            }
            if (str.length() >= 2) {
                cnt2++;
            }
        }
        System.out.println(cnt1+" "+cnt2);

    }
}
