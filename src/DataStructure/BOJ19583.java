package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//싸이버개강총회
public class BOJ19583 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();
        String input;
        Set<String> set = new HashSet<>();
        int cnt = 0;
        while ((input = br.readLine()) != null) {
//            System.out.println("1");
            String[] str = input.split(" ");
            System.out.println(Arrays.toString(str));
            if (str[0].compareTo(s) <= 0) {
                set.add(str[1]);
            }
            else if (str[0].compareTo(e) >= 0 && str[0].compareTo(q) <= 0) {
                if(set.contains(str[1])) {
                    cnt++;
                    set.remove(str[1]);
                }

            }

        }
        System.out.println(cnt);


    }
}
