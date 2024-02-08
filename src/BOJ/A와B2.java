package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A와B2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int result = dfs(s, t);
        System.out.println(result);

    }

    private static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }
        int ans = 0;
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            ans += dfs(s, string);
        }
        if (t.charAt(t.length() - 1) == 'A') {
            String substring = t.substring(0, t.length() - 1);
            ans += dfs(s, substring);
        }

        return ans>0?1:0;
    }
}
