#include <string>
#include <vector>
#include <sstream>
#include <cstring>

using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    
     int size = friends.size();

    // 선물지수
    vector<int> scores(size);

    // 최종적으로 받게될 선물 개수
    vector<int> presents(size);

    // 선물 주고받은 기록 저장할 배열
    int record[size][size];
    memset(record, 0, sizeof(record));

    string front_word;
    string back_word;
    
    // 선물 주고받은 사람 체크
    int giver_idx;
    int receiver_idx;

    for(int i = 0; i < gifts.size(); i++) {
        string gift = gifts[i];
        stringstream ss(gift);

        ss >> front_word >> back_word;
        
        // 선물 주고 받은 기록 
        for (int j = 0; j < friends.size(); j++) {
            // 앞 문자는 준 사람, 뒷 문자는 받은 사람
            if (friends[j] == front_word) {
                giver_idx = j;
                scores[j]++;
            }
            if (friends[j] == back_word) {
                receiver_idx = j;
                scores[j]--;
            }
        }
        record[giver_idx][receiver_idx]++;
    }

    // 받게될 선물 개수 계산
    for (int i = 0; i < size; i++) {
        for (int j = i + 1; j < size; j++) {
            // 주고받은 선물 개수가 다른 경우
            if (record[i][j] > record[j][i]) {
                presents[i]++;
            }
            else if (record[i][j] < record[j][i]){
                presents[j]++;
            }
            // 주고받은 선물 개수가 같은 경우
            else {
                // 선물지수 비교
                if (scores[i] > scores[j]) {
                    presents[i]++;
                }
                else if (scores[i] < scores[j]) {
                    presents[j]++;
                }
                else {
                }
            }
        }
    }

    // 가장 선물을 많이 받는 사람의 개수
    for (int i = 0; i < size; i++) {
        if (answer < presents[i]){
            answer = presents[i];
        }
    }
    
    return answer;
}
