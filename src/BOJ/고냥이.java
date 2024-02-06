package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 고냥이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int left = 0,right =0,cnt=1;
        int[] alp = new int[26];
        alp[input.charAt(0) - 'a']++;
        int max_length=0;
        while (right < input.length()-1) {
            right++;
            if (alp[input.charAt(right) - 'a']++ == 0) {
//                alp[input.charAt(right) - 'a']++;
                cnt++;
            }
            while (cnt > n && left < right) {
//                alp[input.charAt(left)-'a']--;
                if (--alp[input.charAt(left++) - 'a'] == 0) cnt--;
            }
//            System.out.printf("%d %d ",left,right);
            max_length = Math.max(max_length, right - left+1);
//            System.out.println(max_length);
        }
        System.out.println(max_length);
    }
}
