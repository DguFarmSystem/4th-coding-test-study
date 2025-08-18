import java.util.*;
    
class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        char[][] map = new char[storage.length][storage[0].length()];
        for(int i=0; i<storage.length; i++){
            map[i] = storage[i].toCharArray();
        }
        
        int n = map.length;
        int m = map[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        
        for(String request: requests){
            
            char target = request.charAt(0);
            
            if(request.length()==2){
                for(int i =0; i<n; i++){
                    for(int j=0; j<m;j++){
                        if(map[i][j]==target){
                            map[i][j] = '0';
                        }
                    }
                }
                
            }
            else{  
                //시작점 테두리
                for(int i =0; i<n; i++){
                    for(int j=0; j<m;j++){
                        if((map[i][j]=='0'||map[i][j]==target) && (i==0 || j==0 || i==n-1 || j==m-1)){
                            visited[i][j]=true;
                            queue.offer(new int[]{i,j});
                        }
                    }
                }
                
                while(!queue.isEmpty()){
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    
                    if(map[x][y]==target){
                        map[x][y] = '0';
                    }
                    
                    for(int[] d:dir){
                        int nx = x + d[0];
                        int ny = y + d[1];
                    
                        if(nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]){
                            visited[nx][ny]=true;
                            queue.offer(new int[]{nx,ny});    
                        }
                    }
                    
                } 
                
            }
 
        }
        
      
        for(int k=0; k<n; k++){
           for(int v=0; v<m; v++){
                if(map[k][v]!='0'){
                    answer++;
                }
            }
        }

            return answer;
          
        }
        
        
        
}
