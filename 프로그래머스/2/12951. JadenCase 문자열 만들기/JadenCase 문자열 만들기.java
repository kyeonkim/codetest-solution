class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.toLowerCase().split(" ", -1);
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                answer
                    .append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1));
            }
            if (i < words.length - 1) {
                answer.append(" ");
            }
        }
        return answer.toString();
    }
}