#include <string>
#include <vector>
#include <numeric>
#include <queue>
#include <iostream>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    long long sumA = accumulate(queue1.begin(), queue1.end(), 0);
    long long sumB = accumulate(queue2.begin(), queue2.end(), 0);
    
    // 합이 홀수인 경우
    if((sumA + sumB) % 2 != 0) return -1;
    
    queue<int> q1;
    queue<int> q2;
    
    for(const int &i : queue1) q1.push(i);
    for(const int &i : queue2) q2.push(i);

    
    int answer = 0;
    while (sumA != sumB) {
        // 큐가 비었을 경우 불가능
        // 한바퀴 이상 돌았을 경우 불가능
        if(!q1.size() || !q2.size() || answer > (q1.size()+q2.size())+1){
            answer = -1;
            break;
        }
        
        // A가 더 클때
        if(sumA > sumB){
            int v = q1.front();
            q1.pop();
            q2.push(v);
            sumA -= v;
            sumB += v;
            answer += 1;
        } else {
            int v = q2.front();
            q2.pop();
            q1.push(v);
            sumA += v;
            sumB -= v;
            answer += 1;
        }
    }
    
    return answer;
}
