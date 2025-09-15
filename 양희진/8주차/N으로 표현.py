def solution(N, number):
    dp = [set() for i in range(9)]
    
    for i in range(1, 9): # answer는 8이하
        dp[i].add(int(str(N)*i)) # N, NN, NNN,,,
        
        for j in range(0, i): # i는 사용 횟수
            for k in dp[j]: # j번 사용
                for l in dp[i-j]: # i-j번 사용 
                    dp[i].add(k+l)
                    dp[i].add(k-l)
                    dp[i].add(k*l)
                    if k !=0 and l !=0: 
                        dp[i].add(k//l)
        if number in dp[i]: 
            return i
    
    return -1
  
