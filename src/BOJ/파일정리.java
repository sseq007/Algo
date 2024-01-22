package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파일정리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        while (n-- > 0) {
            String input = br.readLine();
            int idx = input.indexOf(".");
            String substring = input.substring(idx + 1);
            map.put(substring, map.getOrDefault(substring, 0) + 1);

//            System.out.println(map);
        }
        Set<String> key = map.keySet();
        for (String k : key) {
            list.add(k);
        }
        Collections.sort(list);
        for (String k : list) {
            System.out.println(k+" "+map.get(k));
        }
    }
}
