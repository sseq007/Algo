package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독숌 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start= 666;
        int cnt=1;

        while (cnt != n) {
            start++;
            if (Integer.toString(start).contains("666")) {
                cnt++;
            }
        }
        System.out.println(start);

    }
}
