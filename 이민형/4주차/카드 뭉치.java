class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int cnt1 = 0; // cards1 배열 카운트
        int cnt2 = 0; // cards2 배열 카운트
        for (int i = 0; i < goal.length; i++) {
            if (cnt1 < cards1.length && goal[i].equals(cards1[cnt1])) {
                cnt1++;
                continue;
            }
            else if (cnt2 < cards2.length && goal[i].equals(cards2[cnt2])){ 
                cnt2++;
                continue;
            }
            else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
