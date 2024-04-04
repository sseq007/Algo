package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//연산자 끼워넣기
public class BOJ14888 {
    static int n,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
    static int[] arr;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cnt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int idx, int sum) {
        if (idx == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cnt[i] > 0) {
                cnt[i]--;

                if (i == 0) {
//                    sum += arr[idx];
                    dfs(idx+1,sum+arr[idx]);
                } else if (i == 1) {
//                    sum -= arr[idx];
                    dfs(idx+1,sum-arr[idx]);

                } else if (i == 2) {
//                    sum *= arr[idx];
                    dfs(idx+1,sum*arr[idx]);

                } else {
//                    sum /= arr[idx];
                    dfs(idx+1,sum/arr[idx]);

                }
                cnt[i]++;

            }
        }

    }


}
