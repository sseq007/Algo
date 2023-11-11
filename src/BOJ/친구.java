package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 친구 {

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
        int max_val = 0;
        for (int i = 0; i < n; i++) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] v = new boolean[n];
            q.add(i);
            v[i] = true;
            int count=0;
            int depth=0;
            while (depth < 2) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int p = q.poll();
                    for (int k = 0; k < n; k++) {
                        if (map[p][k] == 'Y' && !v[k]) {
                            v[k] = true;
                            q.add(k);
                            count++;
                        }
                    }
                }
                depth++;
            }
            max_val = Math.max(max_val, count);
        }
        System.out.println(max_val);
    }
}
