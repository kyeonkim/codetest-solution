import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();

        // 마을마다 연결된 마을들과 배달 시간을 포함하여 맵으로 저장
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            
            map.putIfAbsent(a, new ArrayList<>()); // 맵 안에 해당 키가 '없을' 경우, value를 넣음
            map.get(a).add(new int[]{b, c});
            
            map.putIfAbsent(b, new ArrayList<>());
            map.get(b).add(new int[]{a, c});
        }
        // 다익스트라 알고리즘을 구하기 위한 우선순위큐, 
        // 배달 시간을 기준으로 정렬 시킬 거라 Comparator을 이용
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1]; // 각 마을까지의 최소 배달 시간을 저장
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new int[]{1, 0});
        
        // 우선순위큐를 돌며 1부터 연결된 마을까지의 최소 배달 시간을 dist에 저장
        while(!pq.isEmpty()) {
            int[] curValue = pq.poll();
            int curTown = curValue[0], curTime = curValue[1];
            
            if (curTime > dist[curTown]) continue;
            
            List<int[]> neighbors = map.get(curTown);
            for (int[] neighbor: neighbors) {
                int nextTown = neighbor[0], nextTime = neighbor[1];
                int newTime = curTime + nextTime;
                
                if (newTime < dist[nextTown]) {
                    dist[nextTown] = newTime;
                    pq.offer(new int[]{nextTown, newTime});
                }
            }
        }
        // dist가 K보다 작거나 같은 값이면 answer 증가
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K)
                answer++;
        }
        return answer;
    }
}