import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, String> hash = new HashMap<String, String>();
        
        int temp_today = Integer.valueOf(today.split("\\.")[0]) * 12 * 28 + Integer.valueOf(today.split("\\.")[1]) * 28 + Integer.valueOf(today.split("\\.")[2]);
        
        for (int i = 0; i < terms.length; i++) {
            hash.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }
        
        for (int i = 0; i < privacies.length; i++) {
            int temp_privacies = Integer.valueOf(privacies[i].split("\\.")[0]) * 12 * 28 + Integer.valueOf(privacies[i].split("\\.")[1]) * 28 + Integer.valueOf(privacies[i].split(" ")[0].split("\\.")[2]) + Integer.valueOf(hash.get(privacies[i].split(" ")[1])) * 28 - 1;
            
            if (temp_privacies < temp_today) {
                result.add(i);
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i) + 1;
        }
        
        return answer;
    }
}
