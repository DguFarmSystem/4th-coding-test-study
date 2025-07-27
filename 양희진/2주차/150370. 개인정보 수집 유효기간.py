def solution(today, terms, privacies):
    answer = []
    
    y, m, d = map(int, today.split('.'))
    
    term = {}
    for i in terms:
        a,b = i.split()
        term[a] = int(b)
        
    for i in range(len(privacies)):
        day, t = privacies[i].split()
        py, pm, pd = map(int, day.split('.'))
        pm += term[t]
        pd -= 1
        if pd == 0:
            pd = 28
            pm -= 1
            if pm == 0:
                pm = 12
                py -= 1
        while pm > 12:
            pm -= 12
            py += 1
        if py < y:
            answer.append(i+1)
            continue
        elif py == y and pm < m:
            answer.append(i+1)
            continue
        elif py == y and pm == m and pd < d:
            answer.append(i+1)
            continue
    return answer
