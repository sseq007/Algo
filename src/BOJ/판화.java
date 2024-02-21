package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 판화 {

    static int n;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (char[] c : map) {
            Arrays.fill(c, '.');
        }
        String input = br.readLine();
        int x = 0, y = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'D') {
                if (x != n - 1) {
                    if (map[x][y] == '.') {
                        map[x][y] = '|';
                    } else if (map[x][y] == '-') {
                        map[x][y] = '+';
                    }
                    x++;
                    if (map[x][y] == '.') {
                        map[x][y] = '|';
                    } else if (map[x][y] == '-') {
                        map[x][y] = '+';
                    }
                }

            } else if (input.charAt(i) == 'U') {
                if (x != 0) {
                    if (map[x][y] == '.') {
                        map[x][y] = '|';
                    } else if (map[x][y] == '-') {
                        map[x][y] = '+';
                    }
                    x--;
                    if (map[x][y] == '.') {
                        map[x][y] = '|';
                    } else if (map[x][y] == '-') {
                        map[x][y] = '+';
                    }
                }

            } else if (input.charAt(i) == 'L') {
                if (y != 0) {
                    if (map[x][y] == '.') {
                        map[x][y] = '-';
                    } else if (map[x][y] == '|') {
                        map[x][y] = '+';
                    }
                    y--;
                    if (map[x][y] == '.') {
                        map[x][y] = '-';
                    } else if (map[x][y] == '|') {
                        map[x][y] = '+';
                    }
                }

            } else {
                if (y != n - 1) {
                    if (map[x][y] == '.') {
                        map[x][y] = '-';
                    } else if (map[x][y] == '|') {
                        map[x][y] = '+';
                    }
                    y++;
                    if (map[x][y] == '.') {
                        map[x][y] = '-';
                    } else if (map[x][y] == '|') {
                        map[x][y] = '+';

                    }

                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

}
