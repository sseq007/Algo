package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 블로그2 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;
        List<String> bList = new ArrayList<>();
        List<String> rList = new ArrayList<>();

        String line = bf.readLine();
        StringTokenizer st = new StringTokenizer(line, "R");

        while (st.hasMoreTokens()) {
            bList.add(st.nextToken());
        }

        st = new StringTokenizer(line, "B");

        while (st.hasMoreTokens()) {
            rList.add(st.nextToken());
        }

        if (rList.size() >= bList.size()) {
            answer = bList.size() + 1;
        } else {
            answer = rList.size() + 1;
        }

        System.out.println(answer);
        Map<String, Integer> map = new HashMap<>();
        Iterator<Integer> it2 = map.values().iterator();
        while (it2.hasNext()) {
            it2.next();
        }
        Iterator<String> it = map.keySet().iterator();

        while (it.hasNext()) {
            it.next();
        }
        String a = "abc";
        System.out.println(a.indexOf("b"));

    }

}
