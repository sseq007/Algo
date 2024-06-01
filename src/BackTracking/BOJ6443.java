package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//애너그램
public class BOJ6443 {


    static int[] v;
    static char[] sel;
    static char[] arr;
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            arr = br.readLine().toCharArray();
            v = new int[26];
            sel = new char[arr.length];
            for (int i = 0; i < arr.length; i++) {
                v[arr[i]-'a']++;
            }
            dfs(0);

            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append("\n");
            }


        }
        System.out.println(sb);



    }

    private static void dfs(int idx) {
        if (idx == sel.length) {
            String str = "";
            for (char c : sel) {
                str += c;
            }
            pq.add(str);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(v[i]<=0) continue;
            v[i]--;
            sel[idx] = (char)(i+'a');
            dfs(idx + 1);
            v[i]++;
        }
    }
}
