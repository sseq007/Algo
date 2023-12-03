package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 과일서리 {

    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        long a =1,b=1;
        for(int i = M-N+1;i<=M-1;i++) {
            a *= i;
        }

        for(int i=1; i<=N-1;i++) {
            b*= i;
        }
        long result = (a/b);
        System.out.println(result);

    }


}
