package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//boj 2660
public class 회장뽑기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];
        int max = 251;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = max;
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==-1&&b==-1) break;
            arr[a][b]=1;
            arr[b][a]=1;
         }

        for (int k = 1; k <=n ; k++) {
            arr[k][k]=1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <=n ; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }


        int min = Integer.MAX_VALUE;
        int[] scores = new int[n+1];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
            int score =0;
            for (int j = 1; j <= n; j++) {
                scores[i] = Math.max(scores[i], arr[i][j]);
            }
            min = Math.min(min, scores[i]);
        }

        for (int i = 1; i <=n; i++) {
            if (scores[i] == min) {
                list.add(i);
            }
        }
        Collections.sort(list);

        System.out.println(min+" "+list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }


    }
}
