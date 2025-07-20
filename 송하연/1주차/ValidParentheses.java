import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();
    
        for(int i=0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch == '(') { // char은 작은 따옴표
                stack.push(String.valueOf(ch)); //String 형 변환  
            }
                
            else if (ch == ')'){
                if(stack.isEmpty()) answer = false;
                else stack.pop();
            }
        }
        
        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
