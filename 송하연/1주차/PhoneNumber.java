import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String num : phone_book){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
         for(String num : phone_book){
    
            for(int i = 1; i <= num.toString().length(); i++ ){
                String sb = num.substring(0,i);
         
                if(map.containsKey(sb) && (sb != num)) {
                    answer = false; 
                    return answer;
                }

            }     
        }
        
        return answer;
    }
}
