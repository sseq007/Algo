package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left=0,right=0,sum=0,result=Integer.MAX_VALUE;

        while (left < n) {
            if (sum >= s) {
                result = Math.min(result, right - left);
                sum-=arr[left];
                left++;
            } else if (right >= n) {
                sum-=arr[left];
                left++;
            } else {
                sum += arr[right];
                right++;
            }
        }
        System.out.println(result==Integer.MAX_VALUE?0:result);
    }
}
