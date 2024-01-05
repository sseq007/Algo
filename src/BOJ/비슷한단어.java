package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 비슷한단어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String basic = br.readLine();

        int result=0;
        for (int tc = 0; tc <n-1 ; tc++) {
            String word = br.readLine();
            int[] words = new int[26];
            int same = 0;
            for (int i = 0; i < basic.length(); i++) {
                words[basic.charAt(i)-'A']++;
            }

            for (int i = 0; i < word.length(); i++) {
                if (words[word.charAt(i) - 'A'] > 0) {
                    same++;
                    words[word.charAt(i)-'A']--;
                }
            }
            //같은경우
            if(basic.length()==word.length()&&basic.length()==same) result++;
            //바뀐경우
            else if(basic.length()==word.length()&&basic.length()-1==same) result++;
            //추가한 경우
            else if(basic.length()==word.length()-1&&word.length()-1==same) result++;
            //빠진 경우
            else if(basic.length()==word.length()+1&&word.length()==same) result++;


        }
        System.out.println(result);

    }
}
