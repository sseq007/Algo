package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 과제는끝나지않아 {
    static class homework{
        int score,time;
        public homework(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
    static int n ,a,t;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Stack<homework> stack = new Stack<>();
        int total=0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            if (flag == 1) {
                a = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());
                if(t-1>0){
                    stack.push(new homework(a, t - 1));
                }else{
                    total+=a;
                }
            }else {
                if(!stack.isEmpty()){
                    homework h = stack.pop();
                    if (h.time - 1 > 0) {
                        stack.push(new homework(h.score, h.time - 1));
                    }else {
                        total += h.score;
                    }
                }

            }
        }
        System.out.println(total);
    }
}
