import java.util.*;

public class test {

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
        Collections.sort(list,((o1,o2)->o1-o2));
        System.out.println(list);
        System.out.println(map.get(1));

    }
}
