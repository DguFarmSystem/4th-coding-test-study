from collections import deque # 큐 위해 deque 사용 (리스트보다 속도 빠름)

def solution(queue1, queue2):
    answer = 0
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    
    if sum1 == sum2:
        return answer
    elif (sum1+sum2) %2 !=0: # 합이 홀수면 바로 불가능
        return -1
    else:
        # half = (sum1+sum2)/2
        # for i in range(len(queue1)): 
        #     if queue1[i] > half or queue2[i] > half:
        #         return -1
        if max(max(queue1), max(queue2)) > (sum1+sum2)/2:
            return -1
            
#     deque1 = deque()
#     deque2 = deque()
#     for i in range(len(queue1)):
#         deque1.append(queue1[i])
#         deque2.append(queue2[i])
    deque1 = deque(queue1)
    deque2 = deque(queue2)
    
    while sum1 != sum2 and answer < 3*len(queue1): # 여기 이해 안 됨 ..
        if sum1 > sum2:
            x = deque1.popleft()
            deque2.append(x)
            sum1 -= x
            sum2 += x
        else:
            x = deque2.popleft()
            deque1.append(x)
            sum1 += x
            sum2 -= x
        answer += 1
    
    if sum1 == sum2:
        return answer
    else:
        return -1
