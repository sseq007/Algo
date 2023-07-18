package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 거스름돈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int anw = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                anw+=n/5;
                n=0;
                break;
            }

            n-=2;
            anw++;
        }
        if (n != 0) {
            System.out.println(-1);
        } else {
            System.out.println(anw);
        }
    }
}
