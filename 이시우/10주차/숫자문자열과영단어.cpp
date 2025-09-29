#include <string>
#include <vector>
#include <map>
#include <cctype>

using namespace std;

map<string, char> m = {{"zero",'0'},{"one",'1'},{"two",'2'},{"three",'3'},{"four",'4'},{"five",'5'},{"six",'6'},{"seven",'7'},{"eight",'8'},{"nine",'9'}};
int solution(string s) {
    string str = "";
    string answer = "";

    for(char i:s){
        if(isdigit(i)) answer += i;
        else {
            str += i;
            // 해당하는 영어 문자열 있음
            if(m.find(str) != m.end()){
                answer += m[str];
                str = "";
            }
        }
    }
    
    return stoi(answer);
}
