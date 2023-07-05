package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] input = new char[5][15];
        StringBuilder sb = new StringBuilder();
        int maxLength=0;
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            maxLength = Math.max(maxLength, str.length());
            for (int j = 0; j <str.length() ; j++) {
                input[i][j]=str.charAt(j);
            }
        }for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j <5 ; j++) {
                if(input[j][i]==0) continue;
                sb.append(input[j][i]);
            }
        }
        System.out.println(sb.toString());

    }
}
