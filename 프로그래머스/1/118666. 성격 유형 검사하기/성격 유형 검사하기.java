// 유형 별 점수를 기록할 맵을 하나 만든다.
// 4와 비교하여 같으면 넘어가고
// 4보다 클 경우에는 servey[i][1]의 유형으로 choices[i] - 4의 점수를 더해준다.
// 4보다 작을 경우 servey[i][0]의 유형으로 4 - choices[i] 의 점수를 더해준다.
// 유형 별 점수 기록이 끝났으면, 지표에 따라 유형을 비교하여 결과를 넣고 반환한다.

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> kptt = new HashMap<>();
        kptt.put('R', 0);
        kptt.put('T', 0);
        kptt.put('C', 0);
        kptt.put('F', 0);
        kptt.put('J', 0);
        kptt.put('M', 0);
        kptt.put('A', 0);
        kptt.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            char type1 = survey[i].charAt(0);
            char type2 = survey[i].charAt(1);
            if (choices[i] > 4) {
                kptt.put(type2, kptt.get(type2) + (choices[i] - 4));
            } 
            else if (choices[i] < 4) {
                kptt.put(type1, kptt.get(type1) + (4 - choices[i]));    
            }
        }
        
        StringBuilder answer = new StringBuilder();
        
        answer.append(kptt.get('R') >= kptt.get('T') ? 'R' : 'T');
        answer.append(kptt.get('C') >= kptt.get('F') ? 'C' : 'F');
        answer.append(kptt.get('J') >= kptt.get('M') ? 'J' : 'M');
        answer.append(kptt.get('A') >= kptt.get('N') ? 'A' : 'N');
        
        return answer.toString();
    }
}

// Map.of라는게 있지만 한번 설정 시 변경이 불가능함
// Map<Character, Integer> initKptt = Map.of(
//     'R', 0,
//     'T', 0,
//     'C', 0,
//     'F', 0,
//     'J', 0,
//     'M', 0,
//     'A', 0,
//     'N', 0
// );
