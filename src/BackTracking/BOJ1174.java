package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//줄어드는 수
public class BOJ1174 {

    static int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        recur(0, 0);
        Collections.sort(arr);
//        System.out.println(arr.size());
        System.out.println(arr.size()<n?-1:arr.get(n - 1));
    }

    private static void recur(int idx, long num) {
        if(!arr.contains(num)) arr.add(num);
        if (idx == 10) return;

        recur(idx + 1, num * 10 + nums[idx]);
        recur(idx + 1, num);

    }
}
