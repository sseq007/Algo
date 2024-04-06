package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//블로그
public class BOJ21921 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left=0,right=0,sum=arr[0],cnt=1,max=0,count=1;

        while (left <= right) {
            right++;
            if (right >= n) {
                break;
            }
            cnt++;
            sum += arr[right];

            if (cnt == x) {
                if (max < sum) {
                    max = sum;
                    count=0;
                }
                if (max == sum) {
                    count++;
                }
                cnt=x-1;
                sum -= arr[left];
                left++;
            }

        }
        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}
