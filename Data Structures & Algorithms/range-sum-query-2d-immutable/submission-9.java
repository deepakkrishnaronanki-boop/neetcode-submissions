class NumMatrix {

    int[][] numMat;

    public NumMatrix(int[][] matrix) {
        
        int rows= matrix.length, cols = matrix[0].length;
        numMat = new int[rows+1][cols+1];

        for(int i = 0; i < rows; i++) {
            int sum = 0;
            for(int j = 0; j < cols; j++) {
                sum += matrix[i][j];
                numMat[i+1][j+1] = sum + numMat[i][j+1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;

        int bottomRight = numMat[row2][col2];
        int topRight = numMat[row1-1][col2];
        int bottomLeft = numMat[row2][col1-1];
        int topLeft = numMat[row1-1][col1-1];

        return bottomRight - topRight - bottomLeft + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */