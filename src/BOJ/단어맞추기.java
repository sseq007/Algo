package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 단어맞추기 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            char[] charArray = br.readLine().toCharArray();
            int last = charArray.length - 1;
            int right = charArray.length - 1;
            while (right > 0 && charArray[right - 1] >= charArray[right]) {
                right--;
            }

            if (right > 0) {
                int cur = last;
                while(charArray[right-1]>=charArray[cur]) cur--;
                swap(charArray, right - 1, cur);
                while (right < last) {
                    swap(charArray, right, last);
                    right++;
                    last--;
                }
            }

            for (char c : charArray) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }


}
