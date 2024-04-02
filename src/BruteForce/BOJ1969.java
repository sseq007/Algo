package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1969 {

    static int n,m;
    static String[] arr;
    static String[] code = {"A", "C", "G", "T"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(arr[j].substring(i,i+1), map.getOrDefault(arr[j].substring(i,i+1), 0) + 1);
            }
            List<Integer> list = new ArrayList<>(map.values());
            Collections.sort(list, Collections.reverseOrder());
            int max = list.get(0);
//            System.out.println(map);
            for (int j = 0; j < 4; j++) {
                if (map.get(code[j])!=null&&map.get(code[j]) == max) {
                    sb.append(code[j]);
                    cnt += n - map.get(code[j]);
                    break;
                }
            }

            map.clear();
        }
        System.out.println(sb);
        System.out.println(cnt);
    }


}
