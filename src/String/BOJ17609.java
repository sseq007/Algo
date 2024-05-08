package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//회문
public class BOJ17609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String str = br.readLine();

            if (isSame(str)==0) {
                System.out.println(0);
            } else {
                int left =0,right=str.length()-1;
                boolean flag= false;
                while (left <= right) {
                    if (str.charAt(left) == str.charAt(right)) {
                        left++;
                        right--;
                    } else {
                        //left 삭제
                        String origin = str.substring(0,left)+str.substring(left+1,str.length());
                        if (isSame(origin) == 0) {
                            flag = true;
                            break;
                        }
                        //right 삭제
                        String origin2 = str.substring(0,right)+str.substring(right+1,str.length());
                        if (isSame(origin2) == 0) {
                            flag = true;
                            break;
                        }
                        break;
                    }

                }
                if (flag) System.out.println(1);
                else System.out.println(2);

            }
        }

    }

    private static int isSame(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        if(str.equals(sb.toString())) return 0;
        return 1;
    }
}
