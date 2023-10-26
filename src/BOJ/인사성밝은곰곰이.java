package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 인사성밝은곰곰이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int cnt=0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                map.clear();
                continue;
            }
            if (map.containsKey(input)) {
                continue;
            }
            map.put(input, map.getOrDefault(input, 0) + 1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
