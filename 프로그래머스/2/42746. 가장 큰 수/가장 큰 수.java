import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String res[] = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; ++i){
            res[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(res, new Comparator<String>(){
            public int compare(String n1, String n2) {
                return ((n2+n1).compareTo(n1+n2));
            }
        });
        if (res[0].equals("0"))
            return "0";
        for (String str : res)
            answer += str;
        return answer;
    }
}