class Solution {
    public int solution(String s) {
        int min = s.length();
        int sLen = s.length();
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 1; i <= sLen / 2; ++i){
            String prev = "";
            String cur = "";
            StringBuilder result = new StringBuilder();
            int cnt = 1;
            for (int j = 0; j < sLen; j += i){
                int end = j + i;
                if (end > sLen) end = sLen;
                cur = sb.substring(j, end);
                if (cur.equals(prev))
                    cnt++;
                else if (!prev.isEmpty()){
                    result.append(cnt == 1 ? prev : Integer.toString(cnt) + prev);
                    cnt = 1;
                }
                prev = cur;
            }
            result.append(cnt == 1 ? prev : Integer.toString(cnt) + prev);
            if (min > result.length())
                min = result.length();
        }
        return min;
    }
}
