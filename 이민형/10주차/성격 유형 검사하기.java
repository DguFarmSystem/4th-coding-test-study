import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int l = survey.length;
        HashMap<Character, Integer> mbti = new HashMap<>();
        
        mbti.put('R', 0);
        mbti.put('T', 0);
        mbti.put('C', 0);
        mbti.put('F', 0);
        mbti.put('J', 0);
        mbti.put('M', 0);
        mbti.put('A', 0);
        mbti.put('N', 0);
        
        for (int i = 0; i < l; i++) {
            char a = survey[i].charAt(0);
            char b = survey[i].charAt(1);
            
            if (choices[i] > 4) {
                mbti.put(b, mbti.get(b) + choices[i] - 4);
            }
            else if (choices[i] < 4) {
                mbti.put(a, mbti.get(a) - choices[i] + 4);
            }
        }
        
        if (mbti.get('R') >= mbti.get('T')) {
            answer += "R";
        }else {
            answer += "T";
        }
        
        if (mbti.get('C') >= mbti.get('F')) {
            answer += "C";
        }else {
            answer += "F";
        }
        
        if (mbti.get('J') >= mbti.get('M')) {
            answer += "J";
        }else {
            answer += "M";
        }
        
        if (mbti.get('A') >= mbti.get('N')) {
            answer += "A";
        }else {
            answer += "N";
        }
        
        return answer;
    }
}
