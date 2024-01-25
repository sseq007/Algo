package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 센서 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] sensor = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        Integer[] diff = new Integer[n-1];
        for (int i = 0; i < n-1; i++) {
            diff[i] = sensor[i + 1] - sensor[i];
        }
        Arrays.sort(diff, Collections.reverseOrder());

        int sum = 0;

        for (int i = k - 1; i < n-1; i++) {
            sum += diff[i];
        }
        System.out.println(sum);

    }
}
