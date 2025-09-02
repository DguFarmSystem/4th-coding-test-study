import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 100000000;
        boolean isRight = false; // target이 words에 있는지 확인용
        Queue<String[]> q = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>(); // 딕셔너리를 이용하여 개수 지정
        int count = 0;
        
        for (String s:words) { // target이 있는지 찾기
            if (s.equals(target)) {
                isRight = true;
            }
        }
        if (!isRight) { // target이 words에 없다면 바로 끝
            answer = 0;
            return answer;
        }
        
        // 딕셔너리로 각각 개수 저장해놓기
        for (String s:words) {
            count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (begin.charAt(i) == s.charAt(i)) {
                    count++;
                }
            }
            dict.put(s, count);
        }
        
        // 큐에 하나씩 넣기 -> 되는것들만
        // visited는 끝나면 초기화
        // answer은 최솟값 비교로 받기
        for (int i = 0; i < words.length; i++) {
            if (dict.get(words[i]) == words[0].length() - 1) { // 한 자리 제외 전부 같은 것들만 넣기
                q.add(new String[]{words[i], "1"});
                visited.add(words[i]);
            }
            while (!q.isEmpty()) {
                String[] load = q.remove();
                if (load[0].equals(target)) { // 만약 target과 같다면 끝
                    if (Integer.valueOf(load[1]) < answer) { // 최솟값 비교
                        answer = Integer.valueOf(load[1]);
                    }
                }
                else {
                    for (String s:words) {
                        int tmp_cnt = 0;
                        for (int j = 0; j < s.length(); j++) {
                            if (s.charAt(j) == load[0].charAt(j)) {
                                tmp_cnt++;
                            }
                        }
                        if (tmp_cnt == s.length() - 1) {
                            if (!visited.contains(s)) {
                                q.add(new String[]{s, String.valueOf(Integer.valueOf(load[1]) + 1)});
                                visited.add(s);
                            }
                        }
                    }
                }
            }
            visited.clear();
        }
        
        return answer;
    }
}
