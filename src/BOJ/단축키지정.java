package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 단축키지정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String words ="";
            boolean flag = false;
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                if (!map.containsKey(str.substring(0,1))&&!flag) {
                    map.put(str.substring(0, 1).toLowerCase(), str);
                    map.put(str.substring(0, 1).toUpperCase(), str);
                    words+="["+str.substring(0,1)+"]"+str.substring(1)+" ";
                    flag = true;
                }else{
                    words+=str+" ";
                }

            }
            if (!words.contains("[") && !words.contains("]")) {
                StringTokenizer word = new StringTokenizer(words, " ");

                String words2 = "";
                boolean flag2 = false;
                while (word.hasMoreTokens()) {
                    String str = word.nextToken();
//                    System.out.println(str);
                    if (flag) {
                        words2 += str + " ";

                    } else {
                        for (int j = 1; j < str.length(); j++) {
                            if (!map.containsKey(Character.toString(str.charAt(j)))) {
                                words2 += str.substring(0, j) + "[" + str.substring(j, j + 1) + "]" + str.substring(j + 1);
                                map.put(str.substring(j, j + 1).toLowerCase(), str);
                                map.put(str.substring(j, j + 1).toUpperCase(), str);
                                flag2 = true;
                                break;
                            }
                        }
                    }
                }
                System.out.println(words2);

            } else {
                System.out.println(words);
            }

        }

    }
}
