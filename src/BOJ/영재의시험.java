package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영재의시험 {
    static int[] correct;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        correct = new int[10];
        arr = new int[10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            correct[i] = Integer.parseInt(st.nextToken());
        }
        result = 0;
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int idx) {
        if (idx ==10) {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (correct[i] == arr[i]) {
                    cnt++;
                }
            }
            if (cnt >= 5) {
                result++;
            }
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (idx >= 2 && arr[idx - 1] == i+1 && arr[idx - 2] == i+1) {
                continue;
            }
            arr[idx] = i+1;
            dfs(idx + 1);
        }
    }
}
