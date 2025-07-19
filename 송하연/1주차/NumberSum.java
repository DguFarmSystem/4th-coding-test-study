import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=0; i < n; i++){
        int total = 0;
        int num = i+1;
            
            while(total < n){
                total += num; 
                num ++;
                
                if(total == n){ answer ++; break;}
            }
        }
        return answer;
    }
}
