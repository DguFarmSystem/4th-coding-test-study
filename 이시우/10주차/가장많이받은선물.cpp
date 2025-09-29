#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <algorithm>

using namespace std;

int board[50][50];
int score[50];
int result[50];
map<string, int> m;
int N;
int solution(vector<string> friends, vector<string> gifts) {
    N = friends.size();
    
    // map에 index 등록하기
    for(int i=0; i<N; i++){
        m[friends[i]] = i;
    }
    
    // board에 선물기록 기록
    for(auto s: gifts){
        int split = s.find(' ');
        string A = s.substr(0,split);
        string B = s.substr(split+1);
        board[m[A]][m[B]]++;
    }
    
    // 선물지수 계산
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            // 준 사람 +
            score[i] += board[i][j];
            // 받은 사람 -
            score[j] -= board[i][j];
        }
    }
    
    // 선물 계산
    for(int i=0; i<N; i++){
        for(int j=i+1; j<N; j++){
            if(board[i][j]>board[j][i]) result[i]++;
            else if(board[i][j]<board[j][i]) result[j]++;
            else {
                if(score[i]==score[j]) continue;
                result[score[i]>score[j] ? i : j]++;
            }
        }
    }
    
    // 가장 많이 받은 선물 수
    int answer = 0;
    for(int i=0; i<N; i++){
        answer = max(answer, result[i]);    
    }
    
    return answer;
}
