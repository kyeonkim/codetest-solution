import java.lang.Integer;

class Solution {
    public int[] solution(String s) {
        int count = 0, zeroNum = 0;
        int size, zeroCnt;
        
        while (!s.equals("1")) {
            size = s.length();
            zeroCnt = 0;
            for (int i = 0; i < size; i++)
                if (s.charAt(i) == '0') zeroCnt++;
            s = Integer.toBinaryString(size - zeroCnt);
            count++;
            zeroNum += zeroCnt;
        }
        
        return new int[]{count, zeroNum};
    }
}