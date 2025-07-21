import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        char[] temp = s.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (st.size() != 0 && temp[i] == ')' && st.peek().equals('(')) {
                st.pop();
            }
            else {
                st.push(temp[i]);
            }
        }
        
        if (st.size() != 0) {
            answer = false;
        }

        return answer;
    }
    
    public static void main() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        
        Solution sol = new Solution();
        sol.solution(s);
    }
}
