package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자놀이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = m; i <= n; i++) {
            String english = change(i);
            map.put(english, i);
            list.add(english);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && i % 10 == 0) {
                System.out.println();
            }
            System.out.print(map.get(list.get(i))+" ");

        }
    }

    private static String change(int input) {

        String str = Integer.toString(input);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                sb.append("zero ");
            } else if (str.charAt(i) == '1') {
                sb.append("one ");
            } else if (str.charAt(i) == '2') {
                sb.append("two ");
            } else if (str.charAt(i) == '3') {
                sb.append("three ");
            } else if (str.charAt(i) == '4') {
                sb.append("four ");
            } else if (str.charAt(i) == '5') {
                sb.append("five ");
            } else if (str.charAt(i) == '6') {
                sb.append("six ");
            } else if (str.charAt(i) == '7') {
                sb.append("seven ");
            } else if (str.charAt(i) == '8') {
                sb.append("eight ");
            } else if (str.charAt(i) == '9') {
                sb.append("nine ");
            }

        }
        return sb.toString();
    }
}
