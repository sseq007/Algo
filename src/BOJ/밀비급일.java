package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 밀비급일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringBuilder sb2 = new StringBuilder();
            String input = br.readLine();
            if (input.equals("END")) {
                break;
            }
            sb2.append(input).reverse();
            sb.append(sb2.toString()).append("\n");
        }

        System.out.println(sb.toString());

    }
}
