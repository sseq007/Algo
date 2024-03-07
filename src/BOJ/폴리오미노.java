package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String str = input.replaceAll("XXXX", "AAAA");
        String replaceStr = str.replaceAll("XX", "BB");
        if (replaceStr.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(replaceStr);
        }
    }
}
