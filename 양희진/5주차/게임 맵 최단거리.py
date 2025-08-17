from collections import deque

def solution(maps):
    n = len(maps) # 행
    m = len(maps[0]) # 열
    # 상하좌우
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    queue = deque()
    queue.append((0,0))
    visited = [[False]*m for _ in range(n)]
    while queue:
        x,y = queue.popleft()
        
        for i in range(4): # 상하좌우 확인
            nx = x + dx[i] # 행
            ny = y + dy[i] # 열
        
            if nx<0 or ny<0 or nx>=n or ny>=m: # 길 밖이면
                continue
            if maps[x][y] == 0: # 벽이면
                continue 
            if maps[nx][ny] == 1 and visited[nx][ny] == False: # 길이고 방문 안 했으면
                visited[nx][ny] = True
                maps[nx][ny] = maps[x][y] + 1 # 경로 개수 추가(answer)
                queue.append((nx,ny)) 

    if maps[n-1][m-1] == 1:
        return -1
    else:
        return maps[n-1][m-1]
