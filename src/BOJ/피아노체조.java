package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 피아노체조 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];

        String[] str = br.readLine().split(" ");
        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(str[i - 1]);

            if (arr[i - 1] > arr[i]) {
                sum[i] = sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }

        }
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < q; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(sum[y] - sum[x]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
