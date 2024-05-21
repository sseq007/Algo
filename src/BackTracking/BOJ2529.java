package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//부등호
public class BOJ2529 {


    static int n;
    static String[] str;
    static boolean[] v;
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine().split(" ");
        v = new boolean[10];
        list = new ArrayList<>();
        dfs("", 0);
//        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void dfs(String sum, int idx) {
        if (idx == n + 1) {
            list.add(sum);

            return;
        }
        for (int i = 0; i < 10; i++) {
            if(v[i]) continue;

            if (idx == 0 || check(sum.charAt(idx - 1)-'0', i, str[idx - 1])) {
                v[i] = true;
                dfs(sum + i, idx + 1);
                v[i] = false;
            }
        }
    }

    private static boolean check(int a, int b, String oper) {
        if (oper.equals(">")) {
            if (a > b) return true;
            else return false;
        } else {
            if(a<b) return true;
            else return false;
        }
    }
}
