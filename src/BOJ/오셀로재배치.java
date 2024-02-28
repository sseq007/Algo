package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 오셀로재배치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();
            int wCount = 0, bCount = 0;
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    if (str1.charAt(i) == 'W') {
                        bCount++;
                    } else {
                        wCount++;
                    }
                }
            }
            int min = Math.max(bCount, wCount);

            System.out.println(min);
        }
    }
}
