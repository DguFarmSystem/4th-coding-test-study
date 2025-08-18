import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] visited = new int[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0,0});
        visited[0][0] = 1;
        
        int[] dx = {-1, 1, 0, 0}; 
        int[] dy = {0, 0, -1, 1}; 
        
        int cnt = 0;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
         
            for(int i= 0; i < dx.length; i++ ){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
            
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visited[nx][ny] ==0 && maps[nx][ny] == 1){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = visited[now[0]][now[1]] + 1;
                }     
                if (nx == n - 1 && ny == m - 1)  return answer = visited[nx][ny];
            }
            

        }
        
        return answer = -1;
    }
}
