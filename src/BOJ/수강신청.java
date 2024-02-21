package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String input = br.readLine();
            if (set.contains(input)) {
                set.remove(input);
            }
            set.add(input);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String str : set) {
            if (count == k) {
                break;
            }
            sb.append(str + "\n");
            count++;
        }
        System.out.println(sb);
    }
}
