#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

long long spell_to_int(string s){
    long long sum = 0;
    for(long long i=0; i<s.length(); i++){
        sum += s[i]-'a'+1;
        if(i!=s.length()-1)
            sum *= 26;
    }
    return sum;
}

string int_to_spell(long long n){
    string result = "";
    long long mod = 0;
    while(n!=0) {
        mod = (n-1) % 26;
        n = (n-1) / 26;
        result = char('a'+mod) + result;
    }

    return result;
}

bool compare(string a, string b){
    return spell_to_int(a) < spell_to_int(b);
}

string solution(long long n, vector<string> bans) {
    string answer = "";

    sort(bans.begin(), bans.end(),compare);

    for(string i: bans){
        if(spell_to_int(i)<=n) n++;
        else break;
    }

    answer = int_to_spell(n);

    return answer;
}
