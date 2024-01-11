package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴짝수연속한부분수열 {

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
        int left=0,right=0,even=0,odd=0,result=0;

        if(arr[0]%2==0) even++;
        else odd++;
        result = even;
        while (left <= right) {
            if (odd > k) {
                if(arr[left]%2==0) even--;
                else odd--;
                left++;

            } else {
                right++;
                if(right==n) break;
                if(arr[right]%2==0) even++;
                else odd++;
                result = Math.max(result, even);
            }
        }
        System.out.println(result);
    }
}
