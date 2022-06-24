class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        solveDfs(image, sr, sc, color, image[sr][sc]);
            return image;
    }
    
    public void solveDfs(int[][] image, int row, int col, int newColor, int oldColor) {
        
        if(row >= image.length || col >= image[0].length || row < 0 || col < 0 || image[row][col] != oldColor)
            return;
        
        image[row][col] = newColor;
        
        solveDfs(image, row+1, col, newColor, oldColor);
        solveDfs(image, row-1, col, newColor, oldColor);
        solveDfs(image, row, col+1, newColor, oldColor);
        solveDfs(image, row, col-1, newColor, oldColor);
    }
}