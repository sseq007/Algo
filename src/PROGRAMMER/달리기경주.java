package PROGRAMMER;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] calling = {"kai", "kai", "mine", "mine"};
        String[] solution = solution(players, calling);
        Map<String, Integer> map = new HashMap<>();
        System.out.println(Arrays.toString(solution));
    }
    public static void copy(String[] players,String[] anwser){
        for(int i=0;i<players.length;i++){
            anwser[i]=players[i];
        }
    }
    public static int findIdx(String[] answer,String calling){
        int find=0;
        for(int i=0;i<answer.length;i++){
            if(answer[i].equals(calling)){
                find = i;
                break;
            }
        }
        return find;
    }

    public static void swapPlayer(int idx,String[] answer){
        int targetIdx = idx-1;
        String temp = answer[idx];
        answer[idx]=answer[targetIdx];
        answer[targetIdx]=temp;
        System.out.println(Arrays.toString(answer));
    }


    public static String[] solution(String[] players, String[] callings) {

        String[] answer = new String[players.length];
        copy(players,answer);

        for(int i=0;i<callings.length;i++){
            int idx = findIdx(answer,callings[i]);
            System.out.println(idx);
            swapPlayer(idx,answer);
        }

        return answer;
    }



}
