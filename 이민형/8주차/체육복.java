import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Arrays.sort(reserve);
        Arrays.sort(lost);
        
        //reserve가 lost 당했을 때
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    reserve[i] = 0;
                    lost[j] = 0;
                }
            }
        }
        
        //reserve가 lost에게 주기
        for (int i = 0; i < reserve.length; i++) {
            if (reserve[i] != 0) {
                for (int j = 0; j < lost.length; j++) {
                    if (lost[j] == 0) {
                        continue;
                    }
                    
                    if (reserve[i] - 1 == lost[j]) {
                        lost[j] = 0;
                        reserve[i] = 0;
                    }
                    else if (reserve[i] + 1 == lost[j]) {
                        lost[j] = 0;
                        reserve[i] = 0;
                    }
                }
            }
        }
        
        // 최종 결과
        for (int l:lost) {
            if (l != 0) {
                answer--;
            }
        }
        
        return answer;
    }
}
