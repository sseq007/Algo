package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//BOJ 10162
public class 전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] time = {300,60,10};
        int[] result= new int[3];
        for (int i = 0; i < time.length; i++) {
            result[i]=t/time[i];
            t%=time[i];
        }

        if (t != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]+" ");
            }
        }

    }
}
