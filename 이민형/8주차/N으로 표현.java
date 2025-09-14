import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        ArrayList<Integer>[] dp = new ArrayList[9]; // 동적계획법
        ArrayList<Integer> temp = new ArrayList<>(); // 모든 수 저장할 공간
        
        dp[1] = new ArrayList<>();
        dp[1].add(N);
        temp.add(N);
        if (temp.contains(number)) {
            return 1; // number 포함하면 바로 끝내기
        }
        
        for (int i = 2; i < 9; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(10 * dp[i - 1].get(0) + N); // 같은 숫자 여러개 넣기
            temp.add(10 * dp[i - 1].get(0) + N);
            if (i != 1) {
                for (int j = 1; j < i; j++) {
                    for (int k = 0; k < dp[j].size(); k++) {
                        for (int r = 0; r < dp[i-j].size(); r++) {
                            // 더하기
                            if (!temp.contains(dp[j].get(k) + dp[i-j].get(r))) { 
                                dp[i].add(dp[j].get(k) + dp[i-j].get(r));
                                temp.add(dp[j].get(k) + dp[i-j].get(r));
                            }
                            // 빼기
                            if (dp[j].get(k) >= dp[i-j].get(r)) {
                                if (!temp.contains(dp[j].get(k) - dp[i-j].get(r))) {
                                    dp[i].add(dp[j].get(k) - dp[i-j].get(r));
                                    temp.add(dp[j].get(k) - dp[i-j].get(r));
                                }
                            }
                            // 곱하기
                            if (!temp.contains(dp[j].get(k) * dp[i-j].get(r))) { 
                                dp[i].add(dp[j].get(k) * dp[i-j].get(r));
                                temp.add(dp[j].get(k) * dp[i-j].get(r));
                            }
                            //나누기
                            if (dp[j].get(k) >= dp[i-j].get(r) && dp[i-j].get(r) != 0) {
                                if (!temp.contains(dp[j].get(k) / dp[i-j].get(r))) { 
                                    dp[i].add(dp[j].get(k) / dp[i-j].get(r));
                                    temp.add(dp[j].get(k) / dp[i-j].get(r));
                                }
                            }
                        }
                    }
                }
                if (temp.contains(number)) {
                    return i; // number 포함하면 바로 끝내기
                }
            }
        }
        
        return answer;
    }
}
