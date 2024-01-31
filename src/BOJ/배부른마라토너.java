package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 배부른마라토너 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);


        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            String input = br.readLine();
            map.put(input, map.get(input) - 1);
        }


            Set<String> keys = map.keySet();
            for (String key : keys) {
                if (map.get(key) >= 1) {
                    sb.append(key);
                    break;
                }
            }

        System.out.println(sb);

    }
}
