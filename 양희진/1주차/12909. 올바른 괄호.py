def solution(s):
    sum1 = 0
    sum2 = 0
    for i in s:
        if i=='(':
            sum1 += 1
        else:
            sum2 += 1
        if sum1 < sum2:
            return False
    if sum1 == sum2:
        return True
    else:
        return False
