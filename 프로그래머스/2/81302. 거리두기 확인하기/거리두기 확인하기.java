// 'P'를 만나면 bfs을 통해 사방 탐색
// 자기 자신과 0보다 작거나 5보다 크면 탐색 X
// 다른 'P'를 만났을 때, 맨해튼 거리가 2이하면 false 리턴
// 'O'를 만나면 해당 지점부터 다시 사방 탐색
// 위 조건에 안걸리면 true 리턴
import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int LEN = 5;
        int[] answer = new int[places.length];
            
        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            boolean flag = true;
            
            for (int j = 0; j < LEN && flag; j++) {
                for (int k = 0; k < LEN && flag; k++) {
                    if (place[j].charAt(k) == 'P') {
                        if (!bfs(place, j, k)) {
                            flag = false;
                        }
                    }
                }
            }
            answer[i] = flag ? 1 : 0;
        }
        return answer;
    }
    
    private boolean bfs(String[] place, int r, int c) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + pos[0];
                int nc = dc[i] + pos[1];
                
                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
                    continue;
                
                int m = Math.abs(nr - r) + Math.abs(nc - c);
                
                if (place[nr].charAt(nc) == 'P' && m <= 2)
                    return false;
                else if (place[nr].charAt(nc) == 'O' && m < 2)
                    q.offer(new int[]{nr, nc});
            }
        }
        return true;
    }
}