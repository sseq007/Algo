import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left =0,right=n-1,cnt =0,sum = 0;

        while(left<right){
            sum = arr[left]+arr[right];
            if(sum ==k){
                cnt++;
                left++;
            }else if(sum>k){
                right--;
            }else{
                left++;
            }

        }

        System.out.println(cnt);


    }
}
