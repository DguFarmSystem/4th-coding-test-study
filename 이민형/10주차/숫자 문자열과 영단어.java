class Solution {
    public int solution(String s) {
        String answer = "";
        int length = s.length();
        
        int i = 0;
        while(i < length) {
            if (s.charAt(i) == 'z') {
                answer += "0";
                i += 4;
            }
            else if (s.charAt(i) == 'o') {
                answer += "1";
                i += 3;
            }
            else if (s.charAt(i) == 't') {
                if (s.charAt(i+1) == 'w') {
                    answer += "2";
                    i += 3;
                }else {
                    answer += "3";
                    i += 5;
                }
            }
            else if (s.charAt(i) == 'f') {
                if (s.charAt(i+1) == 'o') {
                    answer += "4";
                }else {
                    answer += "5";
                }
                i += 4;
            }
            else if (s.charAt(i) == 's') {
                if (s.charAt(i+1) == 'i') {
                    answer += "6";
                    i += 3;
                }else {
                    answer += "7";
                    i += 5;
                }
            }
            else if (s.charAt(i) == 'e') {
                answer += "8";
                i += 5;
            }
            else if (s.charAt(i) == 'n') {
                answer += "9";
                i += 4;
            }
            else {
                answer += String.valueOf(s.charAt(i));
                i++;
            }
        }
        int n = Integer.parseInt(answer);
        
        return n;
    }
}
