import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        List<int[]> list = new ArrayList<>();
        int[] group = new int[3];
        
        for(int i = 0; i<minerals.length; i++){
   
            //5개 그룹별 광물 개수 계산
            switch(minerals[i]){
                case "diamond": 
                    group[0]++; break;
                case "iron":
                    group[1]++; break;
                case "stone":
                    group[2]++;break;
            }
    
            if((i+1)%5==0 || i==minerals.length-1){ //배열 끝에 도달했을 때
                list.add(group);
                group = new int[3];
            } 
        }
     
        // 곡괭이에 따라 최대 사용할 수 있는 그룹 수 제한
        int maxGroupCount = picks[0] + picks[1] + picks[2];
        if (list.size() > maxGroupCount) {
            list = list.subList(0, maxGroupCount);
        }
        
        //그룹별 피로도 큰 순으로 내림차순
        list.sort((a,b)-> (b[0]*25 + b[1]*5 + b[2]) - (a[0]*25 + a[1]*5 + a[2]));
            
        for (int [] g : list) {System.out.println(Arrays.toString(g));}
        
        // 곡괭이 배정 및 피로도 계산
        for(int i=0; i<list.size(); i++){
            int[] g = list.get(i);
            
            if(picks[0] > 0){
                answer += g[0] + g[1] + g[2]; 
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += 5*g[0] + g[1] + g[2]; 
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += 25*g[0] + 5*g[1] + g[2]; 
                picks[2]--;
            }
            else break;
            
        }
        
        return answer;
    }

}
