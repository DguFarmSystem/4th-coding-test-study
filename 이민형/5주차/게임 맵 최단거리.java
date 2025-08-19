import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 10000000;
        boolean goal = false;
        int[][] visited = new int[maps.length][maps[0].length];
        
        for (int i = 0; i < maps.length; i++) { // visited 만들어주기
            for (int j = 0; j < maps[0].length; j++) {
                visited[i][j] = maps[i][j];
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0, 1}); // 시작점 넣어주기
        visited[0][0] = 0; // 방문처리 필수
        
        // bfs 시작
        while (!queue.isEmpty()) {
            int[] recent = queue.remove();
            
            if (recent[0] == maps.length - 1 && recent[1] == maps[0].length - 1) {
                if (recent[2] < answer) {
                    answer = recent[2];
                }
                goal = true;
            }
            if (recent[0] + 1 < maps.length && visited[recent[0] + 1][recent[1]] == 1) { // 아래
                queue.add(new int[]{recent[0] + 1, recent[1], recent[2] + 1});
                visited[recent[0] + 1][recent[1]] = 0;
            }
            if (recent[0] - 1 > -1 && visited[recent[0] - 1][recent[1]] == 1) { // 위
                queue.add(new int[]{recent[0] - 1, recent[1], recent[2] + 1});
                visited[recent[0] - 1][recent[1]] = 0;
            }
            if (recent[1] + 1 < maps[0].length && visited[recent[0]][recent[1] + 1] == 1) { // 오른쪽
                queue.add(new int[]{recent[0], recent[1] + 1, recent[2] + 1});
                visited[recent[0]][recent[1] + 1] = 0;
            }
            if (recent[1] - 1 > -1 && visited[recent[0]][recent[1] - 1] == 1) { // 왼쪽
                queue.add(new int[]{recent[0], recent[1] - 1, recent[2] + 1});
                visited[recent[0]][recent[1] - 1] = 0;
            }
        }
        
        if (!goal) {
            answer = -1;
        }
        
        
        return answer;
    }
}
