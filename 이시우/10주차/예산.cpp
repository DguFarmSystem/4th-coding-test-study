#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> d, int budget) {
    sort(d.begin(),d.end());
    int answer = 0;

    // 싼 금액의 물품부터 차감
    for(auto i: d){
        if(budget - i >= 0){
            budget -= i;
            answer++;
        }
    }
    
    return answer;
}
