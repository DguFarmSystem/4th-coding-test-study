def solution(land):   
    for i in range(len(land)):
        if i == 0:
            continue
        else:
            for j in range(4):
                if j != 0 and j != 3:
                    land[i][j] += max(max(land[i-1][:j]), max(land[i-1][j+1:]))
                elif j == 0:
                    land[i][j] += max(land[i-1][j+1:])
                elif j == 3:
                    land[i][j] += max(land[i-1][:j])
    return max(land[len(land)-1])
                
