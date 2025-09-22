#include <string>
#include <vector>

using namespace std;

// number가 100만이라 O(N)에 처리해야된다고 생각
// 메인 아이디어는 큰수가 앞으로 작은 수가 뒤로 -> 내림차순이어야함
// 이때 앞자리의 숫자가 더 중요하므로 앞자리부터 시작


// 스택을 사용한 구현
// 스택(지나간 문자열) -- i번째 문자 -- 남은 문자열   <- 형태로 생각
// "78695"로 예시 k=3
// 1. 스택 top 문자열(없음)보다 현재 문자열이 작은지 비교(7) - 스택 없으므로 넘어감
// 2. 뒤의 문자열이 더 작은지 확인 -> 78에서 7<8 이므로 7 pass
// 3. 1,2번조건 만족시 문자열을 스택에 삽입 ex) "7869"이면 7 pass -> 8 삽입
// **1,2,3번 과정을 반복**

// 4. 스택 top 문자열(8)과 현재 문자열 비교(6) -> 8 > 6 이므로 이상 x
// 5. 뒤랑 비교 6 < 9 이므로 6 pass
// 6. 스택이랑 비교 -> 8 < 9 이므로 스택에서 8 삭제
char stack[1000000];
int N;
string solution(string number, int k) {
    int N = number.length();
    // 스택의 top
    int pos = 0;

    // 문자열의 현재 처리 index
    int i=0;
    // k만큼 제거하거나 or 문자열 끝까지 탐색(이미 내림차순인 경우)
    while(i<N&&k>0){
        // 스택의 값이 있고 i의 값보다 작은 경우 pop
        if(pos>0&&(stack[pos-1]<number[i])){
            pos--;
            k--;
            continue;
        }
        
        // 마지막인 경우
        if(i==N-1){
            stack[pos++] = number[i];
            break;
        }

        if(number[i]>=number[i+1]){
            stack[pos++] = number[i++];
        }
        else{
            i++;
            k--;
        }
    }
    
    string answer = "";
    // k만큼 다 삭제한 경우 -> 스택의 값이 정답
    if(k==0){
        for(int j=0; j<pos; j++)
            answer += stack[j];
        answer += number.substr(i);
    // 삭제를 다 안하고 끝까지 온 경우 -> 스택에서 마지막에 삽입된 k개를 제거
    } else {
        for(int j=0; j<pos-k; j++)
            answer += stack[j];
    }
    
    return answer;
}
