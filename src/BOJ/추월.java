package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 추월 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int order = 1;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, order);
            order++;
        }
        boolean[] cars = new boolean[n+1];

        int cnt =1;
        int result =0;
        for (int i = 0; i < n; i++) {
            String ouput = br.readLine();
            //차 순서가 다르면
            if (cnt != map.get(ouput)) {
                cars[map.get(ouput)] = true;
                result++;
            } else {
                for (int j = map.get(ouput)+1; j <= n; j++) {
                    if (!cars[j]) {
                        cnt = j;
                        break;

                    }
                }
            }
        }
        System.out.println(result);
    }
}
