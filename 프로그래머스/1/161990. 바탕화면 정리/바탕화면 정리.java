class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {-1, 51, -1, -1}; // lux, luy, rdx, rdy
        int temp;
        
        for (int i = 0; i < wallpaper.length; ++i)
        {
            if (wallpaper[i].contains("#")) 
            {
                if (answer[0] == -1) 
                    answer[0] = i;
                answer[2] = i;
                temp = wallpaper[i].indexOf('#');
                answer[1] = answer[1] > temp ? temp : answer[1];
                temp = wallpaper[i].lastIndexOf('#');
                answer[3] = answer[3] < temp ? temp : answer[3];
            }
        }
        answer[2] += 1;
        answer[3] += 1;
        return answer;
    }
}