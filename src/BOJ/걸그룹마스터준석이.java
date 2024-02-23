package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 걸그룹마스터준석이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String girlGroup = br.readLine();
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < num; j++) {
                sb.append(br.readLine() + " ");
            }
            map.put(girlGroup, sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            int or = Integer.parseInt(br.readLine());
            list.clear();
            if (or == 0) {
                String str = map.get(input);
                StringTokenizer st2 = new StringTokenizer(str, " ");
                while (st2.hasMoreTokens()) {
                    list.add(st2.nextToken());
                }
                Collections.sort(list);
                for (String s : list) {
                    sb.append(s + "\n");
                }

            } else {
                List<String> list2 = new ArrayList<>(map.keySet());
                for (String s : list2) {
                    StringTokenizer st2 = new StringTokenizer(map.get(s), " ");
                    while (st2.hasMoreTokens()) {
                        if (input.equals(st2.nextToken())) {
                            sb.append(s + "\n");

                        }
                    }
                }

            }
        }
        System.out.println(sb);

    }
}
