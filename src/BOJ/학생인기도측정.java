package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 학생인기도측정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        while (st.hasMoreTokens()) {
            String input = st.nextToken();
            map.put(input, 0);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
               String input = st.nextToken();
                map.put(input, map.get(input) + 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(o1,o2)->{
            if (map.get(o1) == map.get(o2)) {
                return o1.compareTo(o2);
            } else {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });
        for (String key : list) {
            System.out.printf("%s %d\n",key,map.get(key));
        }

    }
}
