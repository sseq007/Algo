package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ 2847
public class 게임을만든동준이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result=0;
        int start = arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            if (arr[i] >= start) {
                result += arr[i] - start + 1;
                start = arr[i] - (arr[i] - start + 1);
            } else {
                start = arr[i];
            }

        }
        System.out.println(result);

    }
}

