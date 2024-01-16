package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        int sum=0;

        for (int i = 1; i < w-1; i++) {
            int left = 0,right=0;

            //왼쪽 최대 높이 구하기
            for (int j = 0; j < i; j++) {
                left = Math.max(left, height[j]);
            }
            //오른쪽 최대 높이 구하기
            for (int j = i+1; j < w; j++) {
                right = Math.max(right, height[j]);
            }
            if (height[i] < left && height[i] < right) {
                sum += (Math.min(left, right) - height[i]);
            }

        }
        System.out.println(sum);
    }
}
