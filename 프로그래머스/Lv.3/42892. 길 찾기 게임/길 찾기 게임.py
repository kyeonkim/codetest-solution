import sys

def solution(nodeinfo):
    # 각 노드에 인덱스를 붙여 왼쪽 트리와 오른쪽 트리를 구분하기 위해 x축을 기준으로 정렬시킨다.
    sort_nodeinfo = sorted([(x, y, (i + 1)) for i, (x, y) in enumerate(nodeinfo)], key=lambda x: x[0])
    answer = [[], []]
    sys.setrecursionlimit(10001) # 파이썬은 재귀로 문제를 해결할 시, 1000으로 제한이 걸려있다. 이를 해제하기 위한 코드
    
    def traversal(nodes):
        if not nodes:
            return
        root = (0, -1, 0)
        # y축이 level을 의미하므로 y 가 가장 높은 노드가 루트 노드가 된다
        for i, node in enumerate(nodes):
            if root[1] < node[1]:
                root = (i, node[1], node[2])
        # 루트 노드를 기준으로 순회를 시작한다.
        answer[0].append(root[2]) # 전위 순회의 경우, 루트 노드가 먼저 들어가므로 먼저 append를 해준다.
        traversal(nodes[:root[0]]) # 루트 노드를 기준으로 왼쪽 서브 트리와
        traversal(nodes[root[0] + 1:]) # 오른쪽 서브 트리를 나눠서 재귀를 돌린다.
        answer[1].append(root[2]) # 후위 순회의 경우, 서브 노드를 먼저 방문하고 루트 노드에 방문하므로 나중에 append를 해준다.
    traversal(sort_nodeinfo)
    return answer