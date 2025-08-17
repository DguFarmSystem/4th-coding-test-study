import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation: operations){
            String[] parts = operation.split(" ");
            String command = parts[0];
            String num = parts[1];
            
            if(command.equals("I")){
                minHeap.offer(Integer.valueOf(num));
                maxHeap.offer(Integer.valueOf(num));
            }
            
        
             if(command.equals("D")){
                 if(minHeap.isEmpty()) continue;
                 
                 else if(num.equals("1")){
                    int max = maxHeap.poll();
                     minHeap.remove(max); 
                  }
                  else if(num.equals("-1")){
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                  }
             }
        }
        if(minHeap.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        
        else{
               answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }
        
        
        return answer;
    }
}
