import java.util.*;

class Solution {
    int solution(int[][] land) {
        int f = 0;
        int[] temp = new int[4];
        
        for (int i = 0; i < land.length - 1; i++) {
            // 얕은 복사, 깊은 복사 확인할것
            for (int j = 0; j < 4; j++) {
                temp[j] = land[i][j];
            }
            Arrays.sort(temp); // temp 정렬
            for (int j = 0; j < 4; j++) { // temp max 값과 같은 인덱스 찾기
                if (temp[3] == land[i][j]) {
                    f = j;
                }
            }
            for (int j = 0; j < 4; j++) {
                if (f == j) { // 최댓값 인덱스와 같다면 두 번째 최댓값 더하기
                    land[i + 1][j] += temp[2];
                }
                else { // 최대값 인덱스와 같지 않다면 최댓값 더하기
                    land[i + 1][j] += temp[3];
                }
            }
        }
        
        Arrays.sort(land[land.length - 1]);
        return land[land.length - 1][3];
    }
}
