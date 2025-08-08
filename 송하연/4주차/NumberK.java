import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int cnt = 0;
        
        for(int[] command : commands){
            
            int start = command[0]-1;
            int end = command[1];
            int k = command[2]-1;
            
            int[] arr = Arrays.copyOfRange(array, start, end);
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
           
            answer[cnt] = arr[k];
            cnt++;
            
        }
        
        
        return answer;
    }
}
