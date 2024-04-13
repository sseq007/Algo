package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//숫자고르기
public class BOJ2668 {

    static int n,start;
    static int[] arr;
    static List<Integer> list;
    static boolean v[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        v = new boolean[n + 1];
        for (int i = 1; i <=n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        list = new ArrayList<>();
        start = 0;
        for (int i = 1; i <= n; i++) {
            v[i] = true;
            start = i;
            dfs(i);
            v[i]=false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static void dfs(int i) {

        if (arr[i] == start) {
            list.add(i);
        }
        if (!v[arr[i]]) {
            v[arr[i]] = true;
            dfs(arr[i]);
            v[arr[i]] = false;
        }
    }


}
