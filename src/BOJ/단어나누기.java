package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단어나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<String> list = new ArrayList<>();
        for (int i = 1; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                list.add(change(input, i, j));
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }

    private static String change(String input, int a, int b) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb1.append(input.substring(0, a)).reverse();
        sb2.append(input.substring(a, b)).reverse();
        sb3.append(input.substring(b)).reverse();

        return sb1.toString()+sb2.toString()+sb3.toString();
    }
}
