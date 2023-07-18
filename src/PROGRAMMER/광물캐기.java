package PROGRAMMER;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 광물캐기 {

    static int[][] arr = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
    static Map<String, Integer> map = new HashMap<>();

    static{
        map.put("diamond",0);
        map.put("iron",1);
        map.put("stone",2);
    }

    static int[] usePick;

    static int totalPick,minTotal=Integer.MAX_VALUE;

    public static int solution(int[] picks, String[] minerals) {

        totalPick = Arrays.stream(picks).sum();
        usePick = new int[totalPick];

        dfs(picks,minerals,0);

        int answer=minTotal;


        return answer;
    }

    private static void dfs(int[] picks, String[] minerals, int idx) {
        if(idx== usePick.length){
//            System.out.println(Arrays.toString(usePick));
            int d=0;
            int total = 0;
            for (int i = 0; i < minerals.length; i+=5) {
                if(d==usePick.length) break;
                for(int j=i;j<i+5;j++){
                    if(j==minerals.length)break;
                    int find = map.get(minerals[j]);
                    total+=arr[usePick[d]][find];

                }
                d++;
            }
            minTotal = Math.min(minTotal, total);
            return ;
        }

        for (int i = 0; i <3 ; i++) {

            if(picks[i]>0){
                usePick[idx] = i;
                picks[i]--;
                dfs(picks, minerals, idx+1);
                picks[i]++;
            }
        }
    }

    public static void main(String[] args) {

        int[] picks = {1, 3, 2};
        String[] minerals={"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int solution = solution(picks, minerals);

        System.out.println(solution);

    }
}
