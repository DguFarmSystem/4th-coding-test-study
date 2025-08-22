import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>(); // dfs를 위한 큐
        Queue<int[]> stack = new LinkedList<>(); // 겹치지 않기 위한 스토리지
        String[][] map = new String[storage.length][storage[0].length()]; // storage를 split으로 나누기 위한 지도
        boolean[][] visited = new boolean[storage.length][storage[0].length()]; // 방문 체크
        
        for (int i = 0; i < storage.length; i++) { // storage를 map으로 바꾸기
            for (int j = 0; j < storage[0].length(); j++) {
                map[i][j] = String.valueOf(storage[i].charAt(j));
            }
        }
        
        for (String r:requests) {
            if (r.length() == 2) { // 같은 알파벳 2개
                for (int i = 0; i < storage.length; i++) {
                    for (int j = 0; j < storage[0].length(); j++) {
                        if (map[i][j].equals(r.split("")[0])) {
                            map[i][j] = "None"; // 모든걸 빼기
                            answer++;
                        }
                    }
                }
            }
            else { // 알파벳 1개
                for (int i = 0; i < storage.length; i++) {
                    for (int j = 0; j < storage[0].length(); j++) {
                        visited[i][j] = false; // 방문 초기화
                    }
                }
                // 패딩 검사 + 길이 있으면 큐에 추가
                for (int i = 1; i < storage[0].length() - 1; i++) { // 가로 추가
                    if (map[0][i].equals("None")) { // 첫 줄에 길이 있다면 큐에 추가
                        queue.add(new int[]{0, i});
                    }
                    if (map[storage.length - 1][i].equals("None")) { // 마지막 줄에 길이 있다면 큐에 추가
                        queue.add(new int[]{storage.length - 1, i});
                    }
                    if (map[0][i].equals(r)) { // 첫 줄에 알파벳이 있다면
                        stack.add(new int[]{0, i});
                        visited[0][i] = true;
                    }
                    if (map[storage.length - 1][i].equals(r)) { // 마지막 줄에 알파벳이 있다면
                        stack.add(new int[]{storage.length - 1, i});
                        visited[storage.length - 1][i] = true;
                    }
                }
                for (int i = 0; i < storage.length; i++) { // 세로 추가
                    if (map[i][0].equals("None")) { // 첫 줄에 길이 있다면 큐에 추가
                        queue.add(new int[]{i, 0});
                    }
                    if (map[i][storage[0].length() - 1].equals("None")) { // 마지막 줄에 길이 있다면 큐에 추가
                        queue.add(new int[]{i, storage[0].length() - 1});
                    }
                    if (map[i][0].equals(r)) { // 첫 줄에 알파벳이 있다면
                        stack.add(new int[]{i, 0});
                        visited[i][0] = true;
                    }
                    if (map[i][storage[0].length() - 1].equals(r)) { // 마지막 줄에 알파벳이 있다면
                        stack.add(new int[]{i, storage[0].length() - 1});
                        visited[i][storage[0].length() - 1] = true;
                    }
                }
                
                while (!queue.isEmpty()) { // bfs 시작
                    int[] tmp = queue.remove(); // 큐의 마지막 인자
                    
                    if (map[tmp[0]][tmp[1]].equals(r)) { // 같으면 stack에 추가
                        stack.add(new int[]{tmp[0], tmp[1]});
                        continue;
                    }
                    if (tmp[0] - 1 > -1 && !visited[tmp[0] - 1][tmp[1]]) { // 위
                        if (map[tmp[0] - 1][tmp[1]].equals("None") || map[tmp[0] - 1][tmp[1]].equals(r)) { 
                            queue.add(new int[]{tmp[0] - 1, tmp[1]});
                            visited[tmp[0] - 1][tmp[1]] = true; // 방문 표시
                        }
                    }
                    if (tmp[0] + 1 < storage.length && !visited[tmp[0] + 1][tmp[1]]) { // 아래
                        if (map[tmp[0] + 1][tmp[1]].equals("None") || map[tmp[0] + 1][tmp[1]].equals(r)) {
                            queue.add(new int[]{tmp[0] + 1, tmp[1]});
                            visited[tmp[0] + 1][tmp[1]] = true; // 방문 표시
                        }
                    }
                    if (tmp[1] - 1 > -1 && !visited[tmp[0]][tmp[1] - 1]) { // 왼
                        if (map[tmp[0]][tmp[1] - 1].equals("None") || map[tmp[0]][tmp[1] - 1].equals(r)) {
                            queue.add(new int[]{tmp[0], tmp[1] - 1});
                            visited[tmp[0]][tmp[1] - 1] = true; // 방문 표시
                        }
                    }
                    if (tmp[1] + 1 < storage[0].length() && !visited[tmp[0]][tmp[1] + 1]) { // 오
                        if (map[tmp[0]][tmp[1] + 1].equals("None") || map[tmp[0]][tmp[1] + 1].equals(r)) {
                            queue.add(new int[]{tmp[0], tmp[1] + 1});
                            visited[tmp[0]][tmp[1] + 1] = true; // 방문 표시
                        }
                    }
                }
                while (!stack.isEmpty()) { // stack에 저장된 값들 None으로 바꿔주기
                    int[] buf = stack.remove();
                    map[buf[0]][buf[1]] = "None";
                    answer++;
                }
            }
        }
        
        return storage.length * storage[0].length() - answer;
    }
}
