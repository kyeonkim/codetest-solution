class Solution {
    private int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows][columns];
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < rows; ++i){
            for (int j = 0; j < columns; ++j){
                matrix[i][j] = i * columns + j + 1;
            }
        }
        for (int i = 0; i < queries.length; ++i){
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }
    
    private int rotate(int[] query){
        int x1 = query[0] - 1; // row
        int y1 = query[1] - 1; // col
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        int temp = matrix[x1][y1];
        int min = temp;
        for (int i = x1; i < x2; ++i){
            matrix[i][y1] = matrix[i + 1][y1];
            if (min > matrix[i][y1]) min = matrix[i][y1];
        }
        for (int i = y1; i < y2; ++i){
            matrix[x2][i] = matrix[x2][i + 1];
            if (min > matrix[x2][i]) min = matrix[x2][i];
        }
        for (int i = x2; i > x1; --i){
            matrix[i][y2] = matrix[i - 1][y2];
            if (min > matrix[i][y2]) min = matrix[i][y2];
        }
        for (int i = y2; i > y1; --i){
            matrix[x1][i] = matrix[x1][i - 1];
            if (min > matrix[x1][i]) min = matrix[x1][i];
        }
        matrix[x1][y1 + 1] = temp;
        return min;
    }
}