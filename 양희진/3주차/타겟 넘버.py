def solution(numbers, target):
    answer = 0 
    sum_lst = [0]
    
    for num in numbers:
        lst = []
        for i in sum_lst:
            lst.append(i+num)
            lst.append(i-num)
        sum_lst = lst
        
    for i in sum_lst:
        if i == target:
            answer += 1
    
    return answer
  
