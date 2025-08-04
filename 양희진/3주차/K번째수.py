def solution(array, commands):
    answer = []
    for i in commands:
        lst = array[i[0]-1:i[1]]
        lst.sort() # lst.sort()는 반환 x / sorted(lst)는 반환 o
        answer.append(lst[i[2]-1])
    return answer
  
