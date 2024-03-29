package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOj1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            if (cnt == k) {
                list.add(q.poll());
                cnt=1;
                continue;
            }

            q.add(q.poll());
            cnt++;

        }
        String result = "<";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                result += Integer.toString(list.get(i)) + ">";
                break;
            }
            result += Integer.toString(list.get(i)) + ", ";
        }
        System.out.println(result);
    }
}
