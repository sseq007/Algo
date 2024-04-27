package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//출석체크
public class BOJ20438 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> sleep = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sleep.add(Integer.parseInt(st.nextToken()));
        }
        boolean[] v = new boolean[n + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(sleep.contains(cur)) continue;
            if(v[cur]) continue;
            for (int j = cur; j < n+3; j++) {
                if (j % cur == 0) {
                    if (!sleep.contains(j)) {
                        v[j] = true;
                    }
                }
            }
        }
        int[] cnt = new int[n + 3];
        for (int i = 3; i < n + 3; i++) {
            cnt[i] = cnt[i - 1] + (!v[i] ? 1 : 0);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(cnt[e] - cnt[s-1]);
        }

    }
}
