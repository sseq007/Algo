package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 접두사 {

    static String[] arr;
    static boolean[] v;
    static int n,min=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        v = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (a, b) ->
                b.length() - a.length()
        );
//        System.out.println(Arrays.toString(arr));
        Set<String> set = new HashSet<>();
        for(String str : arr){
            if (set.size() == 0) {
                set.add(str);
                continue;
            }

            boolean flag = false;
            for (String str2 : set) {
                if (str2.startsWith(str)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                set.add(str);
            }
        }
        System.out.println(set.size());
    }


}
