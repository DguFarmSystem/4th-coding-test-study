class Solution {
    public int solution(String name) {
        int answer = 0;
        
        //위, 아래 최솟값 결정
        for (int i = 0; i < name.length(); i++) {
            int a = 'Z' - name.charAt(i) + 1; // A에서 아래로 내리는 횟수
            int b = name.charAt(i) - 'A'; // A에서 위로 올리는 횟구
            answer += a >= b ? b : a;
        }
        
        // 좌, 우 최솟값 결정
        int move = name.length() - 1; // 가장 기본적인 오른쪽 이동
        for (int i = 0; i < name.length(); i++) {
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {next++;}
            
            // 오른쪽으로 쭉 vs 왼쪽으로 방향틀기
            move = move >= i * 2 + name.length() - next ? i * 2 + name.length() - next : move;
            // 왼쪽부터 시작했을 경우
            move = move >= (name.length() - next) * 2 + i ? (name.length() - next) * 2 + i : move;
        }
        
        
        return answer + move;
    }
}
