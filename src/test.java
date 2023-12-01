import java.util.*;

public class test {

    static class point{
        int x,y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) {
        int[] arr ={1,2,3,1,1,1};
        Map<Integer, Integer> map = new HashMap<>();

        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int val: map.values()){
            list.add(val);
        }
        Collections.sort(list,((o1,o2)->o2-o1));
        System.out.println(list);
        System.out.println(map.get(1));

        List<point> list2 = new ArrayList<>();
        list2.add(new point(1, 12));
        list2.add(new point(3, 11));
        list2.add(new point(2 ,14));
        Collections.sort(list2, ((p1, p2) -> p2.y - p1.y));

        System.out.println(list2);
    }
}
