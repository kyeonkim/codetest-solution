// 우선 discount의 10개를 해쉬맵으로 센다.
// 검사 로직을 진행한다. 같으면 + 1
// i는 10부터 시작하며 discount - 10까지 loop
// discount[i - 10]에 해당하는 값을 - 1 하고 discount[i]에 해당하는 값을 맵에 + 1 한다.
// loop 안에서 검사로직을 진행한다. 같으면 + 1

import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> sales = new HashMap<>();
        int size = want.length;
        
        for (int i = 0; i < 10; i++) {
            String key = discount[i];
            sales.put(key, sales.getOrDefault(key, 0) + 1);
        }
        answer += check(sales, want, number, size);
        for (int i = 10; i < discount.length; i++) {
            sales.put(discount[i - 10], sales.get(discount[i - 10]) - 1);
            sales.put(discount[i], sales.getOrDefault(discount[i], 0) + 1);
            answer += check(sales, want, number, size);
        }
        return answer;
    }
    
    public int check(Map<String, Integer> sales, String[] want, int[] number, int size) {
        for (int i = 0; i < size; i++) {
            if (sales.containsKey(want[i])) {
                if (sales.get(want[i]) != number[i])
                    return 0;
            } else {
                return 0;
            }
        }
        return 1;
    }
}