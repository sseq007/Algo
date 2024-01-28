package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 크로스컨트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            Map<Integer, Integer> map = new HashMap<>();
            int max = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                int input = Integer.parseInt(st.nextToken());
                arr[i] = input;
                map.put(input, map.getOrDefault(input, 0) + 1);
                max = Math.max(max, arr[i]);
            }
            int[] fiveScore = new int[max + 1];
            Map<Integer, Integer> map2 = new HashMap<>();
            Map<Integer, Integer> map3 = new HashMap<>();
            int val = 1;
            for (int i = 1; i <= n; i++) {
                if(map.get(arr[i])!=6) continue;
                map2.put(arr[i], map2.getOrDefault(arr[i], 0) + 1);
                if (map2.get(arr[i]) <= 4) {
                    map3.put(arr[i], map3.getOrDefault(arr[i], 0) + val);
                }
                if (map2.get(arr[i]) == 5) {
                    fiveScore[arr[i]]=val;
                }
                val++;
            }
            ArrayList<Integer> key = new ArrayList<>(map3.keySet());
            Collections.sort(key,(o1,o2)->{
                if (Objects.equals(map3.get(o1), map3.get(o2))) {
                    return fiveScore[o1] - fiveScore[o2];
                } else {
                    return map3.get(o1)-map3.get(o2);

                }
            });
            System.out.println(key.get(0));


        }
    }
}
