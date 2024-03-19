package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 콰트로치즈피자 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] cheese = new String[n];
        for (int i = 0; i < n; i++) {
            cheese[i] = st.nextToken();
        }
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String c = cheese[i];
            if (map.containsKey(c)) continue;
            if (c.endsWith("Cheese")) {
                cnt++;
            }
            map.put(c, 1);
        }
        System.out.println(cnt >= 4 ? "yummy" : "sad");
    }
}
