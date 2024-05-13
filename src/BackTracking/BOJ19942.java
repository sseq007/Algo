package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//다이어트
public class BOJ19942 {

    static int n,minP,minC,minF,minV, minCost = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] v;
    static List<Integer>list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        minP = Integer.parseInt(st.nextToken());
        minF = Integer.parseInt(st.nextToken());
        minC = Integer.parseInt(st.nextToken());
        minV = Integer.parseInt(st.nextToken());
        map = new int[n][5];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        v = new boolean[n];
        list = new ArrayList<>();
        dfs(0, 0, 0, 0, 0, 0);
        Collections.sort(list);

        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
            for (int val : list) {
                System.out.print(val+" ");
            }
        }

    }

    private static void dfs(int idx, int cost, int p, int f, int c, int vi) {


            if (minP <= p && minF <= f && minC <= c && minV <= vi) {
                if (minCost > cost) {
                    minCost = cost;
                    list.clear();
                    for (int i = 0; i < n; i++) {
                        if (v[i]) {
                            list.add(i+1);
                        }
                    }
                }
                return;
            }
            if (idx == n)  return;

            v[idx] = true;
            dfs(idx + 1, cost + map[idx][4], p + map[idx][0], f + map[idx][1], c + map[idx][2], vi + map[idx][3]);
            v[idx] = false;
            dfs(idx + 1, cost, p , f , c , vi );



    }
}
