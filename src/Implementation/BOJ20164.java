package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//홀수 홀릭 호석
public class BOJ20164 {

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        dfs(n,checkOdd(n));
        System.out.printf("%d %d",min,max);
    }

    private static void dfs(String sum,int cnt) {
        //한 자리일 경우
        if (sum.length() == 1) {
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
            return;
        }
        //두 자리일 경우 2개로 나누기
        if (sum.length() == 2) {
            String sum1 = sum.substring(0, 1);
            String sum2 = sum.substring(1, 2);
            int newSum = Integer.parseInt(sum1) + Integer.parseInt(sum2);
            dfs(Integer.toString(newSum), cnt+checkOdd(Integer.toString(newSum)));
        }
        
        //세 자리일 경우 3개의 수로 분할 3개를 더한 값 새로운 수 생성
        if (sum.length() >= 3) {
            for (int i = 1; i < sum.length() - 1; i++) {
                for (int j = i + 1; j < sum.length(); j++) {
                    String sum1 = sum.substring(0,i);
                    String sum2 = sum.substring(i, j);
                    String sum3 = sum.substring(j, sum.length());
                    int newSum = Integer.parseInt(sum1) + Integer.parseInt(sum2) + Integer.parseInt(sum3);
//                    System.out.printf("%s %s %s\n",sum1,sum2,sum3);
//                    System.out.println(newSum);
                    dfs(Integer.toString(newSum), cnt+checkOdd(Integer.toString(newSum)));
                }
            }
        }
    }

    private static int checkOdd(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) - '0') % 2 == 1) {
                cnt++;
            }
        }
        return cnt;
    }

}
