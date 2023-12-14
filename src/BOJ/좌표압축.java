package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] copyArr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            copyArr[i] = input;
        }
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();

        int idx=0;
        for (int val : arr) {


            if (!map.containsKey(val)) {
                map.put(val,idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(copyArr[i])+" ");
        }
        System.out.println(sb);

    }
}
