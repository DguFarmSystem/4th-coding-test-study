#include <string>
#include <vector>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    
    // 각 점수 (RT, CF, JM, AN)
    vector<int> scores(4);
    int size = survey.size();

    for (int i = 0; i < size; i++) {
        int choice = choices[i];
        string type = survey[i];

        // 앞의 타입 증가
        if (choice < 4) {
            char c = type[0];
            switch (c) {
                case 'R': scores[0] += 4 - choice; break;
                case 'T': scores[0] -= 4 - choice; break;
                case 'C': scores[1] += 4 - choice; break;
                case 'F': scores[1] -= 4 - choice; break;
                case 'J': scores[2] += 4 - choice; break;
                case 'M': scores[2] -= 4 - choice; break;
                case 'A': scores[3] += 4 - choice; break;
                case 'N': scores[3] -= 4 - choice; break;
            }
        }
        // 뒤의 타입 증가
        else if (choice > 4) {
            char c = type[1];
            switch (c) {
                case 'R': scores[0] += choice - 4; break;
                case 'T': scores[0] -= choice - 4; break;
                case 'C': scores[1] += choice - 4; break;
                case 'F': scores[1] -= choice - 4; break;
                case 'J': scores[2] += choice - 4; break;
                case 'M': scores[2] -= choice - 4; break;
                case 'A': scores[3] += choice - 4; break;
                case 'N': scores[3] -= choice - 4; break;
            }            
        }
        // 4 고름 --> 변화 X
        else {
        }
    }

    // 검사 결과
    if (scores[0] >= 0) {
        answer.push_back('R');
    } else {
        answer.push_back('T');
    }

    if(scores[1] >= 0){
        answer.push_back('C');
    } else {
        answer.push_back('F');
    }

    if (scores[2] >= 0) {
        answer.push_back('J');
    } else {
        answer.push_back('M');
    }
        
    if (scores[3] >= 0) {
        answer.push_back('A');
    } else {
        answer.push_back('N');
    }

    return answer;
}
