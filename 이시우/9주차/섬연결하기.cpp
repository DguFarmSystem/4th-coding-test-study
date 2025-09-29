#include <string>
#include <vector>
#include <iostream>
#include <bits/stdc++.h>

using namespace std;

// 비용 기준 정렬을 위한 비교함수 선언
bool cmp(vector<int> &v1, vector<int> &v2){
    if(v1[2]==v2[2]){
        if(v1[1]==v2[1])
            return v1[0] < v2[0];
        else return v1[1] < v2[1];
    }
    return v1[2] < v2[2];
}

void change_group(int g, int ng);

int group[100];
int N;
// 두개의 섬을 연결하면 두개를 하나로 통합(같은 그룹)해서 생각
// ex) A,B,C 세개의 섬이 있을 떄 A,B가 연결되면 (AB),C 로 생각
// 위의 경우 A,B의 경로를 하나의 섬이라고 생각
// 결과적으로 모든 섬이 하나가 되면 종결
int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    int count = n;
    N = n;
    
    // 비용 기준 정렬
    sort(costs.begin(), costs.end(), cmp);
    // 초기 그룹 설정
    for(int i=0; i<N; i++) group[i] = i;

    // 섬이 하나가 될 때까지 반복
    while(count != 1){
        for(auto i:costs){
            int A=i[0],B=i[1],cost=i[2];
            // 섬이 이미 연결 되어있는 경우
            if(group[A]==group[B]) continue;

            // 섬 합치기
            change_group(group[A],group[B]); 
            answer += cost;
            count -= 1;
            break;
        }
    }
    
    return answer;
}

// g 그룹을 ng그룹으로 바꾸는 함수
void change_group(int g, int ng){
    for(int i=0; i<N; i++){
        if(group[i]==g) group[i] = ng;
    }
}
