package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 다이어트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int g = Integer.parseInt(br.readLine());
        int w1=1,w2=1;

        while(true){
            int diff = w1*w1-w2*w2;
            if (w1 - w2 == 1 && diff > g) {
                break;
            }
            if (diff < g) {
                w1++;
            } else {
                w2++;
            }
            if (diff == g) {
                list.add(w1);
            }
        }
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i : list) {
                System.out.println(i);
            }
        }

    }
}
