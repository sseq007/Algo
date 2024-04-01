package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
            } else {
                switch (order) {
                    case "pop":
                        sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
                        break;
                    case "size":
                        sb.append(q.size()).append("\n");
                        break;
                    case "empty":
                        sb.append(q.isEmpty() ? 1 : 0).append("\n");
                        break;
                    case "front":
                        sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
                        break;
                    case "back":
                        sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
                        break;
                }
            }

        }
        System.out.println(sb);
    }
}
