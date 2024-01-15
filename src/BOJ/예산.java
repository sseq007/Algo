package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        Arrays.sort(nums);
        int left = 0, right = nums[n - 1];

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum=0;

            for (int i = 0; i < n; i++) {
                if (nums[i] > mid) {
                    sum += mid;
                } else {
                    sum += nums[i];
                }
            }
            if (sum <= m) {
                left = mid + 1;
            } else {
                right=mid-1;
            }
        }
        System.out.println(right);

    }
}
