import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i : queue1){
            q1.offer(i); 
            sum1 += i;
        }
        for(int i : queue2){
            q2.offer(i); 
            sum2 += i ;
        }

        if((sum1+sum2)%2 == 1){return -1;}
        int target = (sum1+sum2)/2;
        
        
        int cnt = 0;
        int maxCount = (queue1.length + queue2.length)*2;
        
        
        while((sum1 != target || sum2 != target) && cnt < maxCount){
    
            if(sum1 > target){
                if(q1.isEmpty()) return -1; 
                int num = q1.poll();
                q2.offer(num);
                
                sum1 -= num;
                sum2 += num;
                
                cnt++;
    
            }
            else if (sum2 > target){
                if(q2.isEmpty()) return -1; 
                int num = q2.poll();
                q1.offer(num);
                
                sum1 += num;
                sum2 -= num;
                
                cnt++;
            }
          
        }

        if(cnt >= maxCount){return -1;}
        else {answer =  cnt;}
        
        return answer;
    }
    
}
