package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 감소하는수 {

    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n <= 10) {
            System.out.println(n);
        } else {
            for (int i = 0; i < 10; i++) {
                dfs(i, 0);
            }
            if (list.size()-1 < n) {
                System.out.println(-1);
                return;
            }
            Collections.sort(list);

            System.out.println(list.get(n));

        }
    }

    private static void dfs(long num, int idx) {
        if (idx > 10) {
            return;
        }

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            long newNum = (num * 10) + i;
            dfs(newNum, idx + 1);
        }
    }
}
