package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 비슷한단어2 {
    static int n,cnt=0;
    static String[] arr;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = change(br.readLine());
        }
        sel = new int[2];
        comb(0, 0);

        System.out.println(cnt);
    }

    private static void comb(int idx, int s) {
        if (idx == sel.length) {

            if (arr[sel[0]].equals(arr[sel[1]])) {
                cnt++;
            }
            return;
        }

        for (int i = s; i < n; i++) {
            sel[idx] = i;
            comb(idx + 1, i + 1);
        }
    }

    private static String change(String s) {

        Map<Character, Character> map = new HashMap<>();
        char c = 'a';
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), c);
                c++;
            }
            str += map.get(s.charAt(i));
        }

        return str;
    }
}
