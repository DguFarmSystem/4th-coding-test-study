def solution(name):
    answer = 0
    move = len(name) - 1

    for i in range(len(name)):
        answer += min(ord(name[i])-ord('A'), 1+ord('Z')-ord(name[i]))

        # 커서 움직임 최소 계산
        next = i + 1
        while next < len(name) and name[next] == "A": # A가 연속 몇 개인지
            next += 1
        distance = min(i, len(name)-next) # 맨끝으로 갈지(◀), 계속 갈지
        move = min(move, i + (len(name)-next) + distance) 

    answer += move
    return answer
