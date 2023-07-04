package BOJ;
import java.io.*;
import java.util.*;
public class 시험점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total1=0;
        int total2=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <4 ; i++) {
            total1 += Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <4 ; i++) {
            total2 += Integer.parseInt(st.nextToken());
        }
        System.out.println(Math.max(total1,total2));
    }
}