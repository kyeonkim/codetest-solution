def solution(park, routes):
    answer = []
    H = len(park)
    W = len(park[0])
    x, y = 0, 0
    for i in range(H):
        for j in range(W):
            if park[i][j] == 'S':
                x, y = i, j
                break
    nwse = {'N':(-1, 0), 'W':(0, -1), 'S':(1, 0), 'E':(0, 1)}
    for route in routes:
        direction, distance = route.split(" ")
        dx, dy = nwse[direction]
        tx, ty = x, y
        for i in range(int(distance)):
            nx = tx + dx
            ny = ty + dy
            if nx < 0 or ny < 0 or nx >= H or ny >= W or park[nx][ny] == 'X':
                tx, ty = x, y
                break
            tx, ty = nx, ny
        x, y = tx, ty
    answer = x, y
    return answer