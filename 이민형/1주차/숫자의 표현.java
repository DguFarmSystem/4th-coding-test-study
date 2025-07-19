import java.util.Scanner;

class Solution {
    int reset = 0;

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            reset = 0;
            for(int j = i; j <= n; j++) {
                if (reset == n) {
                    answer ++;
                    break;
                }
                else if (reset > n) {
                    break;
                }
                else {
                    reset += j;
                }
            }
        }

        return answer + 1;
    }

    public void main() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        Solution sol = new Solution();
        System.out.print(sol.solution(num));
    }

}