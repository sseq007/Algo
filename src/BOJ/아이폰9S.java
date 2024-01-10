package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 아이폰9S {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            set.add(arr[i]);
        }

        int max = 1;
        for (int num : set) {

            int pre = arr[0];
            int cnt = 1;

            for (int i = 1; i < n; i++) {

                if(arr[i]==num) continue;

                if (pre != arr[i]) {
                    cnt = 1;
                } else {
                    cnt++;
                    max = Math.max(max, cnt);
                }
                pre = arr[i];
            }
        }
        System.out.println(max);


    }
}
