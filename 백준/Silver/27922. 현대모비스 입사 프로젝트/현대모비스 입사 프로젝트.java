import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr1[i]= a+b;
            arr2[i]= b+c;
            arr3[i]= a+c;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        int max1=0,max2=0,max3=0;
        for (int i = 0; i < k; i++) {
            max1 +=  arr1[n-i-1];
            max2 +=arr2[n-i-1];
            max3 +=arr3[n-i-1];
        }

        System.out.println(Math.max(max1,Math.max(max2,max3)));
    }
}
