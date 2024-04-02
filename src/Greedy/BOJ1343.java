package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String a = "AAAA";
        String b = "BB";
        boolean flag = false;
        input = input.replace("XXXX", a);
        input = input.replace("XX", b);
        if (input.contains("X")) {
            flag = true;
        }
        System.out.println(flag?-1:input);
        }


}
