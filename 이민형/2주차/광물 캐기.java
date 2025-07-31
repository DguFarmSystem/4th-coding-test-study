import java.util.*;

class Solution {
    public int answer = 100000;
    
    public void back(int[] picks, String[] minerals, int count) {
        int temp = 0;
        // 곡괭이 다 썼을 때
        if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0) {
            if (count < answer) {
                answer = count;
            }
            return;
        }
        
        if (minerals.length <= 5) { // 미네랄이 5개도 안 남았을 떄
            if (picks[0] > 0) { // 다이아 곡괭이
                count += minerals.length;
                if (count < answer) {
                    answer = count;
                }
                count -= minerals.length;
            }
            if (picks[1] > 0) { // 철 곡괭이
                temp = 0;
                for (int i = 0; i < minerals.length; i++) {
                    if (minerals[i].equals("diamond")) {
                        temp += 5;
                    }
                    else {
                        temp++;
                    }
                }
                count += temp;
                if (count < answer) {
                    answer = count;
                }
                count -= temp;
            }
            if (picks[2] > 0) { // 돌 곡괭이
                temp = 0;
                for (int i = 0; i < minerals.length; i++) {
                    if (minerals[i].equals("diamond")) {
                        temp += 25;
                    }
                    else if (minerals[i].equals("iron")){
                        temp += 5;
                    }
                    else {
                        temp ++;
                    }
                }
                count += temp;
                if (count < answer) {
                    answer = count;
                }
                count -= temp;
            }
            return;
        }
        else { // 미네랄이 5개 넘게 남았을 때
            if (picks[0] > 0) { // 다이아 곡괭이
                picks[0] -= 1;
                count += 5;
                String[] sliced = Arrays.copyOfRange(minerals, 5, minerals.length);
                back(picks, sliced, count);
                picks[0] += 1;
                count -= 5;
            }
            if (picks[1] > 0) { // 철 곡괭이
                temp = 0;
                picks[1] -= 1;
                for (int i = 0; i < 5; i++) {
                    if (minerals[i].equals("diamond")) {
                        temp += 5;
                    }
                    else {
                        temp++;
                    }
                }
                count += temp;
                String[] sliced = Arrays.copyOfRange(minerals, 5, minerals.length);
                back(picks, sliced, count);
                picks[1] += 1;
                count -= temp;
            }
            if (picks[2] > 0) { // 돌 곡괭이
                temp = 0;
                picks[2] -= 1;
                for (int i = 0; i < 5; i++) {
                    if (minerals[i].equals("diamond")) {
                        temp += 25;
                    }
                    else if (minerals[i].equals("iron")){
                        temp += 5;
                    }
                    else {
                        temp++;
                    }
                }
                count += temp;
                String[] sliced = Arrays.copyOfRange(minerals, 5, minerals.length);
                back(picks, sliced, count);
                picks[2] += 1;
                count -= temp;
            }
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int count = 0;
        back(picks, minerals, count);
        return answer; 
    }
}
