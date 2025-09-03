import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int temp = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                temp = triangle[i][j];
                if (j > 0 && triangle[i][j] < temp + triangle[i-1][j-1]) {
                    triangle[i][j] = temp + triangle[i-1][j-1];
                }
                if (j < triangle[i].length - 1 && triangle[i][j] < temp + triangle[i-1][j]) {
                    triangle[i][j] = temp + triangle[i-1][j];
                }
            }
        }
        
        Arrays.sort(triangle[triangle.length - 1]);
        return triangle[triangle.length - 1][triangle.length - 1];
    }
}
