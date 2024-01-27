package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 이모티콘 {


    static class Clip{
        int clip,cnt, time;
        public Clip(int clip, int cnt, int time) {
            this.clip = clip;
            this.cnt = cnt;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        Queue<Clip> q = new LinkedList<>();
        boolean[][] v = new boolean[1001][1001];
        q.add(new Clip(0,1,0));
        v[0][1] = true;
        int result =0;
        while (!q.isEmpty()) {
            Clip now = q.poll();
            if (now.cnt == s) {
                result = now.time;
                break;
            }

            //화면에 있는 이모티콘 클립보드에 모두 저장
            q.add(new Clip(now.cnt, now.cnt, now.time + 1));

            if (now.clip != 0 && now.clip + now.cnt <= s && !v[now.clip][now.clip + now.cnt]) {
                v[now.clip][now.clip + now.cnt] = true;
                q.add(new Clip(now.clip, now.clip + now.cnt, now.time + 1));
            }
            if (now.cnt != 0 && !v[now.clip][now.cnt - 1]) {
                v[now.clip][now.cnt - 1] = true;
                q.add(new Clip(now.clip, now.cnt - 1, now.time + 1));
            }



        }
        System.out.println(result);


    }
}
