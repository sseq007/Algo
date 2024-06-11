package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//N으로 만들기
public class BOJ17255 {
    static char[] input;

    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            recur(i, i, "" + input[i],"" + input[i]);
        }
        System.out.println(set.size());
    }

    private static void recur(int left,int right, String str, String path) {
        if (left == 0 && right == input.length - 1) {
            set.add(path);
            return;
        }
        if (left - 1 >= 0) {
            recur(left - 1, right, input[left - 1] + str, path + " " + input[left - 1] + str);
        }
        if (right + 1 < input.length) {
            recur(left, right + 1, str + input[right + 1], path + " " + str + input[right + 1]);
        }


    }
}
