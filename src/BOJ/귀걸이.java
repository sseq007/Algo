package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 귀걸이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            String[] arr = new String[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = br.readLine();
            }
            Map<Integer, String> map = new HashMap<>();
            boolean[] v = new boolean[n + 1];
            for (int i = 0; i < 2 * n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, b);
                } else {
                    v[a] = true;
                }
            }
            for (int i = 1; i <=n; i++) {
                if (!v[i]) {
                    sb.append(num + " " + arr[i]+"\n");
                    break;
                }
            }
            num++;
        }
        System.out.println(sb);
    }
}
