package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9934 {

    static int k;
    static int size;
    static List<Integer>[] graph;
    static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2,k) - 1;
        graph = new List[size + 1];
        order = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
        recur(1, 1, size);
        for (int i = 1; i <= k; i++) {
            for (int val : graph[i]) {
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    private static void recur(int depth, int start, int end) {
        if (depth == k+1) {
            return;
        }
        int mid = (start + end) / 2;
        graph[depth].add(order[mid]);
        recur(depth + 1, start, mid - 1);
        recur(depth + 1, mid + 1, end);
    }
}
