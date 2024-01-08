package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 행운의문자열 {

    static int[] alp = new int[26];
    static int n;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = input.length();
        for (int i = 0; i < n; i++) {
            alp[input.charAt(i)-'a']++;
        }
        recur(0, ' ');
        System.out.println(result);
    }

    private static void recur(int idx, char pre) {
        if (idx == n) {
//            System.out.println(Arrays.toString(alp));
            result++;
            return;

        }

        for (int i = 0; i < 26; i++) {
            if(alp[i]<=0) continue;
            if (pre != (char) (i + 'a')) {
                alp[i]--;
                recur(idx+1,(char)(i+'a'));
                alp[i]++;
            }
        }
    }


}
