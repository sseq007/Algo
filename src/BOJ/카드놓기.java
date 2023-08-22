package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 카드놓기 {

    static int n,k;
    static int[] card;
    static int[] sel;
    static boolean[] v;
    static Map<String,Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        card = new int[n];
        sel = new int[k];
        v = new boolean[n];
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(br.readLine());
        }
        map = new HashMap<>();
        recur(0);
        System.out.println(map.size());
    }

    private static void recur(int idx) {
        if (idx == k) {
            String str = "";
            for (int i = 0; i < sel.length; i++) {
                str+=Integer.toString(sel[i]);
            }
            map.put(str,1);



            return;
        }

        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i]=true;
                sel[idx]=card[i];
                recur(idx+1);
                v[i]=false;
            }
        }
    }
}
