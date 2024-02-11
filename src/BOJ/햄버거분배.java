package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 햄버거분배 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                int idx = Math.max(i - k, 0);
                boolean flag = false;
                for (int j = idx; j < i; j++) {
                    if (check(j, arr)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    idx = i + k >= n ? n - 1 : i + k;
                    for (int j = i + 1; j <= idx; j++) {
                        if (check(j, arr)) {
                            break;
                        }
                    }
                }
            }
        }
        int cnt = 0;
        for (char c : arr) {
            if (c == 'X') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int idx,char[] arr) {

        if (arr[idx] == 'H') {
            arr[idx] = 'X';
            return true;
        }
        return false;
    }
}
