#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    unordered_map<string, int> numMap = 
    { {"zero", 0}, {"one", 1}, {"two", 2}, {"three", 3}, {"four", 4},
    {"five", 5}, {"six", 6}, {"seven", 7}, {"eight", 8}, {"nine", 9}};

    string result = "";
    string temp = "";

    for (int i = 0; i < s.length(); i++) {
        // 숫자인 경우
        if (isdigit(s[i])) {
            result.push_back(s[i]);
        }
        // 문자인 경우
        else {
            temp.push_back(s[i]);
            for (auto it = numMap.begin(); it != numMap.end(); it++) {
                if (temp == it->first) {
                    result.push_back(it->second + '0');
                    temp = "";
                }
            }
        }
    }

    answer = stoi(result);
    
    return answer;
}
