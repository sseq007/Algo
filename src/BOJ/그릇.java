package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그릇 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int sum=10;
        char str = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (str == input.charAt(i)) {
                sum += 5;
            } else {
                sum+=10;
            }
            str = input.charAt(i);
        }
        System.out.println(sum);
    }
}

