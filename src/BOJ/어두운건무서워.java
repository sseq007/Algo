package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 어두운건무서워 {

            public static void main (String[]args) throws Exception {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringBuilder sb = new StringBuilder();

                int width, height, question, sum;
                int r1, c1, r2, c2;

                //(1,1) ~ (x,y)까지의 합 저장
                int[][] picture;

                StringTokenizer st = new StringTokenizer(br.readLine());

                width = Integer.parseInt(st.nextToken());
                height = Integer.parseInt(st.nextToken());
                question = Integer.parseInt(st.nextToken());

                picture = new int[width + 1][height + 1];

                for (int x = 1; x <= width; x++) {

                    st = new StringTokenizer(br.readLine());

                    // picture[x]의 합 저장
                    sum = 0;

                    for (int y = 1; y <= height; y++) {

                        sum += Integer.parseInt(st.nextToken());
                        picture[x][y] = sum + picture[x - 1][y];
                    }
                }

                for (int x = 0; x < question; x++) {
                    st = new StringTokenizer(br.readLine());

                    r1 = Integer.parseInt(st.nextToken());
                    c1 = Integer.parseInt(st.nextToken());
                    r2 = Integer.parseInt(st.nextToken());
                    c2 = Integer.parseInt(st.nextToken());

                    sb.append((picture[r2][c2] - picture[r1 - 1][c2] - picture[r2][c1 - 1] + picture[r1 - 1][c1 - 1]) / ((r2 - r1 + 1) * (c2 - c1 + 1))).append("\n");

                }

                System.out.print(sb);

            }
        }






