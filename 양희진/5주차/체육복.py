def solution(n, lost, reserve):
    answer = n
    lost.sort()
    reserve.sort()
	
    for i in reserve[:]: # reverse의 복사본 순회
        if i in lost:
            reserve.remove(i)
            lost.remove(i)
            
    for i in reserve: 
        if i-1 in lost:
            lost.remove(i-1)
        elif i+1 in lost:
            lost.remove(i+1)
    answer = n - len(lost)
    return answer
