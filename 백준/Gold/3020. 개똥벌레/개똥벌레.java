import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] rock1 = new int[h+1];
        int[] rock2 = new int[h+1];

        for (int i = 0; i < n; i+=2) {
            rock1[Integer.parseInt(br.readLine())]++;
            rock2[Integer.parseInt(br.readLine())]++;
        }



        for (int i = h-1; i >0 ; i--) {

            rock1[i]+=rock1[i+1];
            rock2[i]+=rock2[i+1];
        }


        int  min = Integer.MAX_VALUE,count = 0;

        for (int i = h; i >0; i--) {
            if(rock1[i]+rock2[h-i+1]<min){
                min = rock1[i]+rock2[h-i+1];
                count = 1;
            }else if(rock1[i]+rock2[h-i+1]==min){
                count++;
            }

        }
        System.out.println(min+" "+count);
    }
}
