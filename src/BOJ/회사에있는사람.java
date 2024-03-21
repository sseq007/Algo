package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회사에있는사람 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String order = st.nextToken();
            if (!map.containsKey(name)) {
                map.put(name, 0);
            } else {
                map.remove(name);

            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list,Collections.reverseOrder());
        for (String str : list) {
            System.out.println(str);
        }
    }
}
