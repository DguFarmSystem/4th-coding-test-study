import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        List<int[]> result = new ArrayList<>();
        
         // [x좌표, y좌표, 기둥(0)/보(1), 삭제(0)/설치(1)]
        for(int[] frame : build_frame){
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];
            int workType = frame[3];
            
            if(workType == 1){
                result.add(new int[]{x,y,type});
                if(!isValid(result)){
                    result.remove(result.size()-1);
                }
            }
            else{
                int[] temp = new int[] {x,y,type};
                result.removeIf(e->e[0] == x && e[1]==y && e[2] == type);
                if(!isValid(result)){
                    result.add(temp);
                }
            }
        }
        
        Collections.sort(result, (a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else if(a[1]!=b[1]) return a[1]-b[1];
            else return a[2]-b[2];    
        });
        
        answer = result.stream().toArray(int[][]::new);

        return answer;
    }
    
    private boolean isValid(List<int[]> build_frame){ 
        for(int[] frame : build_frame){
            
            int x = frame[0];
            int y = frame[1];
            int type = frame[2];

            if(type==0){ //기둥일 때
                if(!(y==0 || //바닥
                   exist(build_frame,x,y-1,0) ||//아래 다른 기둥
                   exist(build_frame,x-1,y,1) || //보의 왼쪽
                   exist(build_frame,x,y,1))) //보의 오른쪽
                {
                    return false;
                }
               
            }
            else{ //보일 때
                if(!(exist(build_frame,x,y-1,0)||  //보 왼쪽 아래 기둥 
                    exist(build_frame,x+1,y-1,0)|| //보 오른쪽 아래 기둥
                    (exist(build_frame,x-1,y,1) && exist(build_frame,x+1,y,1)))) //양쪽 끝 부분이 다른 보와 동시에 연결     
                {
                    return false;
                } 
            }
        }
        return true;
    }
    
    private boolean exist(List<int[]> build_frame, int x, int y, int type){
        for(int[] frame: build_frame){
            if(frame[0]==x && frame[1]==y && frame[2]==type) return true;
        }
        return false;
    }
    
}
