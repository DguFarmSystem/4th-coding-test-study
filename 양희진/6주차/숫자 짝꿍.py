from collections import Counter


def solution(X, Y):
    answer = ''
    x = []
    lst = []
    
    # for i in X:
    #     x.append(i)
    x = list(X) # 문자열에서 문자를 하나씩 원소를 가지는 리스트화
    
    # for i in Y:
    #     if i in x:
    #         n = int(i)
    #         lst.append(n)
    #         x.remove(i) 

    cnt = Counter(x) # 원소와 개수를 딕셔너리화
    for i in Y:
        if cnt[i] > 0:
            lst.append(int(i))
            cnt[i] -= 1
    
    # for i in range(len(lst)):
    #     lst[i] = int(lst[i])
        
    lst.sort(reverse=True) 
    
    if len(lst) == 0: 
        answer = "-1"
    elif lst[0] == 0:
        if all(x == 0 for x in lst): # lst 안이 모두 0이면
            answer = "0"
    else:
        answer = ''.join(map(str, lst)) # 원소들을 join
        
    return answer
  
