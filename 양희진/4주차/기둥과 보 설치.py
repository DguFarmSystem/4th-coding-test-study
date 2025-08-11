def solution(n, build_frame):
    answer = [] # [x, y, a]
    
    # a = 0(기둥) / 1(보)
    # b = 0(삭제) / 1(설치)
    for x, y, a, b in build_frame:
        if b == 0: # 삭제
            answer.remove([x, y, a])
            # check F이면 삭제 취소
            if not check(answer):
                answer.append([x, y, a])
        elif b == 1: # 설치
            answer.append([x, y , a])
            # check F이면 설치 취소
            if not check(answer):
                answer.remove([x, y, a])

    answer.sort(key= lambda x : (x[0], x[1], x[2]))
    return answer

def check(answer):
    for x, y, a in answer:
        if a == 0: # 기둥
            if (y != 0 and # 바닥 x
                [x, y-1, 0] not in answer and # 아래에 기둥 x
                [x-1, y, 1] not in answer and # 아래에 보 x
                [x, y, 1] not in answer): # 아래에 보 x
                return False # 무시
        else: # 보 
            if ([x, y-1, 0] not in answer and # 아래에 기둥 x 
                [x+1, y-1, 0] not in answer and # 아래에 기둥 x
                ([x-1, y, 1] not in answer or # 아래에 보 x
                 [x+1, y, 1] not in answer)): # 아래에 보 x
                return False 
    return True
