class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int num = Integer.parseInt(nums[i]);
            if (num < min) min = num;
            if (num > max) max = num;
        }
        answer = min + " " + max;
        return answer;
    }
}