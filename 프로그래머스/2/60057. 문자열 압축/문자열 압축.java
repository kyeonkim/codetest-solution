import java.util.Arrays;

class Solution {
    public int solution(String s) {
        int min = s.length();
        int maxCompressLength = s.length() / 2;
        
        for (int i = maxCompressLength; i >= 1; i--){
            String[] subStringArray = s.split("(?<=\\G.{" + i + "})");
            String equalsStr = subStringArray[0];
            String compressStr = "";
            int compressNum = 1;
            for (int j = 1; j < subStringArray.length; j++){
                if (!equalsStr.equals(subStringArray[j])){
                    compressStr += compressNum == 1 ? equalsStr : Integer.toString(compressNum) + equalsStr;
                    equalsStr = subStringArray[j];
                    compressNum = 1;
                    continue;
                }
                compressNum++;
            }
            compressStr += compressNum == 1 ? equalsStr : Integer.toString(compressNum) + equalsStr;
            if (min > compressStr.length())
                min = compressStr.length();
        }
        return min;
    }
}