package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int left=1,right=1,sum=1,cnt=1;

        while (right != n) {

            if (sum == n) {
                cnt++;
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        System.out.println(cnt);
    }
}
