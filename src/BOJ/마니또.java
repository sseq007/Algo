package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 마니또 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc=0;
        while (true) {
            tc++;
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            Map<String, String> map = new HashMap<>();
            String[] startIdx = new String[20];
            int cnt =0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                startIdx[i]=a;
                map.put(a, b);
            }
            for(int i=0;i<20;i++) {
                String end = map.get(startIdx[i]);
                while (true) {
                    end = map.get(end);
                    if(end==null) break;
                    if (startIdx[i].equals(end)) {
                        cnt++;
                        map.remove(startIdx[i]);
                        break;
                    }
                }
            }
            System.out.println(tc+" "+cnt);
        }
    }
}
