#include <string>
#include <vector>

using namespace std;

int score['Z'-'A'+1];
string category[4] = {"RT","CF","JM","AN"};
int N;
string solution(vector<string> survey, vector<int> choices) {
    N = survey.size();
    // 설문지 점수 더하기
    for(int i=0; i<N; i++){
        int first = int('Z'-survey[i][0]);
        int second = int('Z'-survey[i][1]);
        int choice = choices[i];
        
        if(choice == 4) continue;
        else if(choice < 4){
            score[first] += 4-choice;
        } else {
            score[second] += choice-4;
        }
    }
    
    string answer = "";
    // 유형 정하기
    for(int i=0; i<4; i++){
        int first = int('Z'-category[i][0]);
        int second = int('Z'-category[i][1]);
        
        if(score[first]>=score[second]) answer += category[i][0];
        else answer += category[i][1];
    }
    return answer;
}
