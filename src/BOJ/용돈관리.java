package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용돈관리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] money = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, money[i]);
        }

        int left = max;
        int right = 10000 * 100000;
        int result = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int val = mid;
            for(int i=0; i<n; i++) {
                if(val - money[i] < 0) {
                    val = mid;
                    count += 1;
                }

                val -= money[i];

            }
            if (m >= count) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);


    }
}
