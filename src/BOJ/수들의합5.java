package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int start=1,end=1,sum=0,cnt=0;

        while (end <= n) {


            if (sum + end <= n) {
                sum+=end;
                end++;
            }

            if (sum == n) {
                cnt++;
            } else if (sum > n) {
                sum -= start;
                start++;
            }

        }
        System.out.println(cnt);
    }
}
