package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 편의점2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xList.add(Integer.parseInt(st.nextToken()));
            yList.add(Integer.parseInt(st.nextToken()));
        }
        // 오름차순으로 정렬 -> 중간값을 알아야하기 떄문
        Collections.sort(xList);
        Collections.sort(yList);

        int mid = (int) Math.round((double) n / 2);

        long sum=0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(xList.get(mid - 1) - xList.get(i)) + Math.abs(yList.get(mid - 1) - yList.get(i));
        }
        System.out.println(sum);

    }
}
