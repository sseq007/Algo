package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//달력
public class BOJ20207 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] day = new int[366];
        int maxRight = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j <= end; j++) {
                day[j]++;
            }
        }
        int[] ints = {-1};


        int width =0, sum = 0,height = 0;
        boolean flag = false;
        for (int i = 1; i <= 365; i++) {
            if (day[i] == 0) {
                sum += width * height;
                height=0;
                width = 0;

            } else {
                width++;
                height = Math.max(height, day[i]);
            }

        }
        sum += height * width;
        System.out.println(sum);
    }
}
