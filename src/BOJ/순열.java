package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 순열 {

    static char[] arr;
    static char[] sel;
    static boolean[] v;
    static int n,cnt;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if(str==null) break;
            StringTokenizer st = new StringTokenizer(str);
            String out = st.nextToken();
            arr = out.toCharArray();
            n = Integer.parseInt(st.nextToken());
            sel = new char[arr.length];
            v = new boolean[arr.length];
            cnt =0;
            result = "";
            perm(0);
            if(cnt<n) result = "No permutation";
            System.out.printf("%s %d = %s\n",out,n,result);

        }
    }

    private static void perm(int idx) {
        if (idx == sel.length) {
//            System.out.println(Arrays.toString(sel));
            cnt++;
            if (cnt == n) {
                for (char c : sel) {
                    result += Character.toString(c);
                }
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!v[i]) {
                v[i] = true;
                sel[idx] = arr[i];
                perm(idx + 1);
                v[i]=false;
            }
        }
    }
}
