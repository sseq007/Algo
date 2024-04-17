package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//가장 긴 짝수 연속한 부분 수열(투포인터 풀이)
public class BOJ23857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left=0,right=0,cnt=0,result=0,even=0,odd=0;
        if(arr[0]%2==0) even++;
        else odd++;
        result = even;
        while (left <= right) {

            if (odd <= k) {
                right++;
                if (right == n) {
                    break;
                }
                if (arr[right] % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
                result = Math.max(result, even);
            } else {
                if (arr[left] % 2 == 0) {
                    even--;
                } else {
                    odd--;
                }
                left++;
            }
        }
        System.out.println(result);
    }
}
