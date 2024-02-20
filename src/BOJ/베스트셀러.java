package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        int max= 0;
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
            max = Math.max(max, map.get(input));
        }
        ArrayList<String> list = new ArrayList<>(map.keySet());
        ArrayList<String> list2 = new ArrayList<>();
        for (String key : list) {
            if (map.get(key) == max) {
                list2.add(key);
            }
        }
        Collections.sort(list2);
        System.out.println(list2.get(0));

    }
}
