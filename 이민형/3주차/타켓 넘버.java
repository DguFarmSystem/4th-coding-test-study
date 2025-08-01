class Solution {
    public int temp = 0;
    public int cnt = 0;
    public int answer = 0;
    
    public void DFS(int[] numbers, int target) {
        if (cnt == numbers.length) { // numbers 소진
            if (temp == target) {
                answer += 1;
            }
            return;
        }
        else { // numbers 남음
            // numbers를 양수로 더해주기
            temp += numbers[cnt];
            cnt++;
            DFS(numbers, target);
            cnt--;
            temp -= numbers[cnt];
            // numbers를 음수로 더해주기
            temp -= numbers[cnt];
            cnt++;
            DFS(numbers, target);
            cnt--;
            temp += numbers[cnt];
            return;
        }
    }
    
    public int solution(int[] numbers, int target) {
        DFS(numbers, target);
        return answer;
    }
}
