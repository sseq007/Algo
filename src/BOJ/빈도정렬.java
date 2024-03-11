package BOJ;

import org.w3c.dom.stylesheets.LinkStyle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 빈도정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        List<Integer> origin = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            origin.add(list.get(i));
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }
        Collections.sort(list, (o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return Integer.compare(origin.indexOf(o1), origin.indexOf(o2));
            } else {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });
        for (int i : list) {
            System.out.print(i+" ");
        }
    }

}
