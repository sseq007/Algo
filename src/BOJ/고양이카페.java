package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 고양이카페 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);
        int left = 0;
        int right = n-1;
        int count=0;
        int max =0;
        while (true) {
            if (left >= right) {
                break;
            }
            if (weight[left] + weight[right] <= k) {
                left++;
                right--;
                count++;
            } else {
                right--;
            }

        }
        System.out.println(count);
    }
}
