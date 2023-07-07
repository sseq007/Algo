package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 모음의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        map.put('a',0);
        map.put('e',0);
        map.put('o',0);
        map.put('i',0);
        map.put('u',0);
        map.put('A',0);
        map.put('E',0);
        map.put('O',0);
        map.put('I',0);
        map.put('U',0);

        while(true){
            String input = br.readLine();
            if(input.equals("#")) break;
            int cnt=0;
            for (int i = 0; i <input.length() ; i++) {
                if(map.containsKey(input.charAt(i))){
                    cnt++;
                }
            }
            System.out.println(cnt);
        }


    }
}
