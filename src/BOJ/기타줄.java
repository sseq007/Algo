package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class 기타줄 {

    static class Point{
        int set,one;

        public Point(int set, int one) {
            this.set = set;
            this.one = one;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "set=" + set +
                    ", one=" + one +
                    '}';
        }
    }
    static int n,m;
    static List<Point> arr1;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr1 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr1.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        List<Point> arr2 = arr1.stream()
                .map(o -> o)
                .collect(Collectors.toList());

        Collections.sort(arr1,(o1,o2)-> o1.set-o2.set);
        Collections.sort(arr2, (o1, o2) -> o1.one - o2.one);
        int sum=Integer.MAX_VALUE;
        Point set = arr1.get(0);
        Point one = arr2.get(0);

        sum=Math.min(((n/6)+1)*set.set,n*one.one);
        sum=Math.min(sum,(n/6)*set.set+(n%6)*one.one);
        System.out.println(sum);

    }
}
